package SecondStax.example.SecondStax.FXproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class FXProductController {
    @Autowired
    private SecondStax.example.SecondStax.service.FXProductService fxProductService;

    @GetMapping(value = {"","/"})
    public void getFXByProvider(){
        List<SecondStax.example.SecondStax.model.FXProduct> FXProduct= fxProductService.getFXByProvider(UUID.fromString("123e4567-e89b-12d3-a456-426614174007"));
        System.out.println(FXProduct);
    }
}
