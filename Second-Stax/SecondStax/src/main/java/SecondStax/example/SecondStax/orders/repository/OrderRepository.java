package SecondStax.example.SecondStax.orders.repository;

import SecondStax.example.SecondStax.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

}
