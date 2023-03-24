package SecondStax.example.SecondStax.FXproduct.controller;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.FXproduct.service.FXProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("http://localhost:4200/")
public class FXProductController {
    @Autowired
    private FXProductService fxProductService;

    @GetMapping(value = {"/providerFX/{providerID}"})
    public List<FXProduct> getFXByProvider(@PathVariable("providerID") UUID providerID){
        return fxProductService.getFXByProvider(providerID);
    }
}
