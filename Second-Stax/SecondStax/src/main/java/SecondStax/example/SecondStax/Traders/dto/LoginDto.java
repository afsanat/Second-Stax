package SecondStax.example.SecondStax.traders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
    String email;
    String password;
}
