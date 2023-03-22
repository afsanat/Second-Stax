package SecondStax.example.SecondStax.Providers.controller;

import SecondStax.example.SecondStax.model.FXProduct;
import SecondStax.example.SecondStax.model.Provider;
import SecondStax.example.SecondStax.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/providers")
public class FxOrderingServiceController {

    @Autowired ProviderService providerService;
    @GetMapping(value = {"", "/"})
    public void getAllProviders(){
        List<Provider> allProviders= providerService.getProviders();
        System.out.println(allProviders);
    }

}
