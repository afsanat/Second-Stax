package SecondStax.example.SecondStax.orders.model;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.paymentAccount.model.PaymentAccount;
import SecondStax.example.SecondStax.traders.model.Trader;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;
    @Column(name = "amount")
    private int amount;
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="payment_id")
    private PaymentAccount payment;

    @ManyToOne
    @JoinColumn(name="product_id")
    private FXProduct fxProduct;

    @ManyToOne
    @JoinColumn(name="trader_id")
    private Trader trader;

}
