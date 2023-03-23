package SecondStax.example.SecondStax.paymentAccount.model;

import SecondStax.example.SecondStax.orders.model.OrderStatus;
import SecondStax.example.SecondStax.traders.model.Trader;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name="bank")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="bank")
@Builder
public class PaymentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentId;
    @Column(name = "account")
    private String account;

    @Column(name = "bankname")
    private String bankname;

    @Column(name = "accountAmount")
    private int accountAmount;

    @ManyToOne
    @JoinColumn(name="trader_id")
    private Trader trader;
}
