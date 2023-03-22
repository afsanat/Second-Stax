package SecondStax.example.SecondStax.Traders.model;

import SecondStax.example.SecondStax.orderPlacement.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name="traders")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="traders")
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID traderId;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;

}
