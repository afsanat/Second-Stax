package SecondStax.example.SecondStax.orderPlacement.service;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.FXproduct.repository.FXProductRepository;
import SecondStax.example.SecondStax.Traders.model.Trader;
import SecondStax.example.SecondStax.Traders.repository.TraderRepository;
import SecondStax.example.SecondStax.orderPlacement.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orderPlacement.model.Order;
import SecondStax.example.SecondStax.orderPlacement.model.OrderStatus;
import SecondStax.example.SecondStax.orderPlacement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private FXProductRepository fxProductRepository;
    @Autowired private TraderRepository traderRepository;
    public String saveOrder(OrderPayLoad orderPayLoad){
        Optional<FXProduct> fxProduct = fxProductRepository.findById(orderPayLoad.getFxProduct());
        Optional<Trader> trader = traderRepository.findById(orderPayLoad.getTrader());

        if(fxProduct.isEmpty()){
            throw new NoSuchElementException("This product is no longer available");
        }

        if(trader.isEmpty()){
            throw new NoSuchElementException("Trader no longer exists");
        }

        Order order = Order.builder().amount(orderPayLoad.getAmount()).fxProduct(fxProduct.get())
                .trader(trader.get()).payment(orderPayLoad.getPayment())
                .status(OrderStatus.PENDING).build();
        orderRepository.save(order);
        return "Order saved";
    }

}
