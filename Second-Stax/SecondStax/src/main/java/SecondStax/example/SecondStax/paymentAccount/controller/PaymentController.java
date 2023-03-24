package SecondStax.example.SecondStax.paymentAccount.controller;

import SecondStax.example.SecondStax.paymentAccount.dto.PaymentAccountDto;
import SecondStax.example.SecondStax.paymentAccount.model.PaymentAccount;
import SecondStax.example.SecondStax.paymentAccount.service.PaymentService;
import SecondStax.example.SecondStax.traders.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin("http://localhost:4200/")
public class PaymentController {
    @Autowired private PaymentService paymentService;
    @Autowired
    private TraderRepository traderRepository;

    @PostMapping(value = {"", "/"})
    public void addPayment(@RequestBody PaymentAccountDto paymentAccountDto){
        try{
            paymentService.addAccount(paymentAccountDto);
            System.out.println("payment saved");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/accounts/{traderId}")
    public List<PaymentAccount> getTraderAccounts(@PathVariable("traderId") UUID traderId){
        return paymentService.getTradersAccounts(traderId);
    }

    @GetMapping("/paymentAccount/{paymentID}")
    public PaymentAccount getAccountByID(@PathVariable("paymentID") UUID paymentID){
        return paymentService.getAccount(paymentID);
    }

}
