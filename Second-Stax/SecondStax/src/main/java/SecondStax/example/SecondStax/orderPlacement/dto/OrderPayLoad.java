package SecondStax.example.SecondStax.orderPlacement.dto;

import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class OrderPayLoad {
    private int amount;
    private String payment;
    private UUID fxProduct;
    private UUID trader;
}
