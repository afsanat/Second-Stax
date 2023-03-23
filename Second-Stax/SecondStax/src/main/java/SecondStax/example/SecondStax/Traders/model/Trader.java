package SecondStax.example.SecondStax.traders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
