package SecondStax.example.SecondStax.Providers.service;

import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.Providers.repository.ProviderRepository;
import SecondStax.example.SecondStax.traders.model.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService implements UserDetailsService {
    @Autowired private ProviderRepository providerRepository;
    public List<Provider> getProviders(){
        return providerRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Provider provider = providerRepository.findByEmail(email);
        return new User(provider.getEmail(),provider.getPassword(), new ArrayList<>());
    }

}
