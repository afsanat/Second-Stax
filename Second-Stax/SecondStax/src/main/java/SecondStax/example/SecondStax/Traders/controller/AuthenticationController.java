package SecondStax.example.SecondStax.traders.controller;

import SecondStax.example.SecondStax.traders.authentication.JwtUtil;
import SecondStax.example.SecondStax.traders.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("")
    public String register(){
        return "jwt";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        }catch(Exception e){
            throw new Exception("email or password doesn't exist ");
        }

        return jwtUtil.generateToken(loginDto.getEmail());
    }

    @PostMapping("/logout")
    public String logoutUser() {
        jwtUtil.getCleanJwtCookie();
        return "User successfully logged out";
    }
}
