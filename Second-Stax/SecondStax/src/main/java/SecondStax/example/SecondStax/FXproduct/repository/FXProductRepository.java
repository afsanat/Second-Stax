package SecondStax.example.SecondStax.repository;

import SecondStax.example.SecondStax.model.FXProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FXProductRepository extends JpaRepository<FXProduct, UUID> {
    @Query(nativeQuery = true, value = "select product_id, currency, amount,provider_id  from fxproduct where provider_id=:providerID")
    List<FXProduct> findAllFXProductByProvider(UUID providerID);
}
