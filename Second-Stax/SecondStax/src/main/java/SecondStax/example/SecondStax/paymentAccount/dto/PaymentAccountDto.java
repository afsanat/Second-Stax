package SecondStax.example.SecondStax.paymentAccount.dto;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PaymentAccountDto {

    private String account;

    private String bankname;

    private UUID traderId;
}
