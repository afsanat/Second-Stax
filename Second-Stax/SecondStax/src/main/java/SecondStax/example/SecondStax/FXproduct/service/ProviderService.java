package SecondStax.example.SecondStax.service;

import SecondStax.example.SecondStax.model.FXProduct;
import SecondStax.example.SecondStax.model.Provider;
import SecondStax.example.SecondStax.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired private ProviderRepository providerRepository;
    public List<Provider> getProviders(){
        return providerRepository.findAll();
    }

}
