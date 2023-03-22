package SecondStax.example.SecondStax.FXproduct.controller;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.FXproduct.service.FXProductService;
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
    private FXProductService fxProductService;

    @GetMapping(value = {"","/"})
    public void getFXByProvider(){
        List<FXProduct> FXProduct= fxProductService.getFXByProvider(UUID.fromString("123e4567-e89b-12d3-a456-426614174007"));
        System.out.println(FXProduct);
    }
}
