package SecondStax.example.SecondStax.traders.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignUpDto {
    String fname;
    String lname;
    String email;
    String password;

}
