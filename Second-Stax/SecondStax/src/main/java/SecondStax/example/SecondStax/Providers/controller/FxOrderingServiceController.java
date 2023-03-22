package SecondStax.example.SecondStax.Providers.controller;

import SecondStax.example.SecondStax.Providers.model.Provider;
import SecondStax.example.SecondStax.Providers.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/providers")
public class FxOrderingServiceController {

    @Autowired
    ProviderService providerService;
    @GetMapping(value = {"", "/"})
    public void getAllProviders(){
        List<Provider> allProviders= providerService.getProviders();
        System.out.println(allProviders);
    }

}
