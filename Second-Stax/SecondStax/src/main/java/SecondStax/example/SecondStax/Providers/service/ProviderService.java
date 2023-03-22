package SecondStax.example.SecondStax.Providers.service;

import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.Providers.repository.ProviderRepository;
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
