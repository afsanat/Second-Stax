package SecondStax.example.SecondStax.FXproduct.service;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.FXproduct.repository.FXProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FXProductService {
    @Autowired private FXProductRepository fxProductRepository;
    public List<FXProduct> getFXByProvider(UUID providerId){
        return fxProductRepository.findAllFXProductByProvider(providerId);
    }
}
