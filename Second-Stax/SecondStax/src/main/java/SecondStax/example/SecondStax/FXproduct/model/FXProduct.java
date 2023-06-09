package SecondStax.example.SecondStax.FXproduct.model;

import SecondStax.example.SecondStax.Providers.model.Provider;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="FXProduct")
@Table(name="FXProduct")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class FXProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    @Column(name = "currency", nullable = false)
    @NonNull
    private String currency;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name="provider_id")
    private Provider provider;
}
