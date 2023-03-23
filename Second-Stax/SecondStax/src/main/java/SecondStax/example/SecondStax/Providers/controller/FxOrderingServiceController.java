package SecondStax.example.SecondStax.Providers.controller;

import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.Providers.service.ProviderService;
import SecondStax.example.SecondStax.traders.authentication.JwtUtil;
import SecondStax.example.SecondStax.traders.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/providers")
public class FxOrderingServiceController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired ProviderService providerService;
    @GetMapping(value = {"", "/"})
    public void getAllProviders(){
        List<Provider> allProviders= providerService.getProviders();
        System.out.println(allProviders);
    }

    @PostMapping("/ProviderLogin")
    public String login(@RequestBody LoginDto loginDto) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        }catch(Exception e){
            throw new Exception("email or password doesn't exist ");
        }

        return jwtUtil.generateToken(loginDto.getEmail());
    }
}
