package SecondStax.example.SecondStax.traders.controller;

import SecondStax.example.SecondStax.traders.authentication.JwtUtil;
import SecondStax.example.SecondStax.traders.dto.LoginDto;
import SecondStax.example.SecondStax.traders.dto.SignUpDto;
import SecondStax.example.SecondStax.traders.model.Trader;
import SecondStax.example.SecondStax.traders.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TraderRepository traderRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        }catch(Exception e){
            throw new Exception("email or password doesn't exist ");
        }

        return jwtUtil.generateToken(loginDto.getEmail());
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody SignUpDto signUpDto){
        if(traderRepository.existsByEmail(signUpDto.getEmail())){
            return "User already exists";
        }
        else{
            Trader trader = new Trader(UUID.randomUUID(),signUpDto.getFname(),signUpDto.getLname(), signUpDto.getEmail(), signUpDto.getPassword());
            traderRepository.save(trader);
            return "User Registered";
        }
    }

    @PostMapping("/logout")
    public String logoutUser() {
        jwtUtil.getCleanJwtCookie();
        return "User successfully logged out";
    }
}
