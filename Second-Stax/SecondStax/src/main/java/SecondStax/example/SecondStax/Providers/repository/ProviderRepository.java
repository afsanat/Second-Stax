package SecondStax.example.SecondStax.Providers.repository;

import SecondStax.example.SecondStax.Providers.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
    Provider findByEmail(String email);
}
