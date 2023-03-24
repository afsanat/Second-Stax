package SecondStax.example.SecondStax.orders.repository;

import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{
    @Query(nativeQuery = true, value = "select *  from orders where trader_id=:findByTraderId")
    List<Order> findByTrader(UUID findByTraderId);

    @Query(nativeQuery = true, value = "select *  from orders o join fxproduct f on o.product_id = f.product_id  where f.provider_id=:providerID")
    List<Order> findByProvider(UUID providerID);

}
