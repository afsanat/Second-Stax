package SecondStax.example.SecondStax.orders.service;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.FXproduct.repository.FXProductRepository;
import SecondStax.example.SecondStax.orders.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orders.model.Order;
import SecondStax.example.SecondStax.orders.model.OrderStatus;
import SecondStax.example.SecondStax.orders.repository.OrderRepository;
import SecondStax.example.SecondStax.paymentAccount.model.PaymentAccount;
import SecondStax.example.SecondStax.paymentAccount.repository.PaymentRepo;
import SecondStax.example.SecondStax.traders.model.Trader;
import SecondStax.example.SecondStax.traders.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private FXProductRepository fxProductRepository;
    @Autowired private TraderRepository traderRepository;
    @Autowired
    private PaymentRepo paymentRepo;

    public String saveOrder(OrderPayLoad orderPayLoad){
        Optional<FXProduct> fxProduct = fxProductRepository.findById(orderPayLoad.getFxProduct());
        Optional<Trader> trader = traderRepository.findById(orderPayLoad.getTrader());
        Optional<PaymentAccount> payment = paymentRepo.findById(orderPayLoad.getPayment());

        if(fxProduct.isEmpty()){
            throw new NoSuchElementException("This product is no longer available");
        }

        if(trader.isEmpty()){
            throw new NoSuchElementException("Trader no longer exists");
        }

        Order order = Order.builder().amount(orderPayLoad.getAmount()).fxProduct(fxProduct.get())
                .trader(trader.get()).payment(payment.get())
                .status(OrderStatus.PENDING).build();
        orderRepository.save(order);
        return "Order saved";
    }

    public String cancelOrder(UUID orderId){
        Optional<Order> order = orderRepository.findById(orderId);

        if(order.isEmpty()){
            throw new NoSuchElementException("Order no longer exists");
        }

        Order updateOrder = order.get();
        updateOrder.setStatus(OrderStatus.REJECTED);
        orderRepository.save(updateOrder);
        return "order cancelled";
    }

    public String approveOrder(UUID orderId){
        Optional<Order> order = orderRepository.findById(orderId);

        if(order.isEmpty()){
            throw new NoSuchElementException("Order no longer exists");
        }
        Order updateOrder = order.get();

        if (updateOrder.getFxProduct().getAmount() != 0){
            updateOrder.setStatus(OrderStatus.ACCEPTED);
            orderRepository.save(updateOrder);


            //decrement the provider's total amount
            double tradedAmount = updateOrder.getAmount()*updateOrder.getFxProduct().getPrice();
            int providerRemainingAmount = updateOrder.getFxProduct().getAmount() - (int) tradedAmount;
            updateOrder.getFxProduct().setAmount(providerRemainingAmount);
            fxProductRepository.save(updateOrder.getFxProduct());

            updateOrder.getPayment().setAccountAmount((int) tradedAmount + updateOrder.getPayment().getAccountAmount());
            paymentRepo.save(updateOrder.getPayment());

            return "order accepted";
        }

        else{
            this.cancelOrder(orderId);
            return "The selected provider has no more currencies to sell";
        }
    }

}
