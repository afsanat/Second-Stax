package SecondStax.example.SecondStax.service;

import SecondStax.example.SecondStax.model.FXProduct;
import SecondStax.example.SecondStax.repository.FXProductRepository;
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
