package SecondStax.example.SecondStax.paymentAccount.service;

import SecondStax.example.SecondStax.orders.model.Order;
import SecondStax.example.SecondStax.orders.model.OrderStatus;
import SecondStax.example.SecondStax.paymentAccount.dto.PaymentAccountDto;
import SecondStax.example.SecondStax.paymentAccount.model.PaymentAccount;
import SecondStax.example.SecondStax.paymentAccount.repository.PaymentRepo;
import SecondStax.example.SecondStax.traders.model.Trader;
import SecondStax.example.SecondStax.traders.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired private PaymentRepo paymentRepo;
    @Autowired private TraderRepository traderRepository;
    public List<PaymentAccount> getTradersAccounts(UUID traderId){
        return paymentRepo.findAllPaymentAccountsByTrader(traderId);
    }

    public PaymentAccount getAccount(UUID paymentID){
        return paymentRepo.findBypaymentId(paymentID);
    }

    public String addAccount(PaymentAccountDto paymentAccountDto){
        Optional<Trader> trader = traderRepository.findById(paymentAccountDto.getTraderId());

        if(trader.isEmpty()){
            throw new NoSuchElementException("Trader logged out or doesn't exist ");
        }

        PaymentAccount paymentAccount = PaymentAccount.builder().account(paymentAccountDto.getAccount())
                        .bankname(paymentAccountDto.getBankname()).trader(trader.get()).build();
        paymentRepo.save(paymentAccount);
        return "payment account added";
    }
}
