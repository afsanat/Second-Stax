package SecondStax.example.SecondStax.Providers.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name="providers")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID providerId;

    @Column(name = "FirstName", nullable = false, unique = true)
    @NonNull
    private String FirstName;

    @Column(name = "LastName")
    @NonNull
    private String LastName;
}
