package SecondStax.example.SecondStax.traders.service;

import SecondStax.example.SecondStax.traders.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import SecondStax.example.SecondStax.Traders.model.Trader;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TraderCustomServise implements UserDetailsService {
    @Autowired TraderRepository traderRepository;

    @Override public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Trader trader = traderRepository.findByEmail(email);
        return new User(trader.getEmail(),trader.getPassword(), new ArrayList<>());
    }
}
