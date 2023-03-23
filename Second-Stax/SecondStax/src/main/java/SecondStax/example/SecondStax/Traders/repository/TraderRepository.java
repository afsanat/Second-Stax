package SecondStax.example.SecondStax.traders.repository;

import SecondStax.example.SecondStax.Traders.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TraderRepository extends JpaRepository<Trader, UUID> {
    Trader findByEmail(String email);
}
