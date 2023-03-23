package SecondStax.example.SecondStax.authentication.repository;

import SecondStax.example.SecondStax.authentication.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface AuthenticationRepository extends JpaRepository<SystemUser, UUID> {


}
