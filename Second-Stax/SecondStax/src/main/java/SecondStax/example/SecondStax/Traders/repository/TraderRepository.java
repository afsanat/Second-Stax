package SecondStax.example.SecondStax.Traders.repository;

import SecondStax.example.SecondStax.Traders.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TraderRepository extends JpaRepository<Trader, UUID> {
}
