package SecondStax.example.SecondStax.paymentAccount.repository;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.paymentAccount.model.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PaymentRepo extends JpaRepository<PaymentAccount, UUID> {
    @Query(nativeQuery = true, value = "select * from bank where trader_id=:traderID")
    List<PaymentAccount> findAllPaymentAccountsByTrader(UUID traderID);

    PaymentAccount findBypaymentId(UUID paymentId);
}
