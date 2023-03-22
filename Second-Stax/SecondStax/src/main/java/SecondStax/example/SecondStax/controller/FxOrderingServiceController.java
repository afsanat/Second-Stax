package SecondStax.example.SecondStax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/providers")
public class FxOrderingServiceController {
    @GetMapping(value = {"", "/"})
    public void getUsers(){
        System.out.println("users");
    }
}
