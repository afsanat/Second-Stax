package SecondStax.example.SecondStax.orderPlacement.controller;

import SecondStax.example.SecondStax.orderPlacement.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orderPlacement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(value = {"", "/"})
    public void saveOrders(@RequestBody OrderPayLoad orderPayLoad){
        try{
            String savedOrder = orderService.saveOrder(orderPayLoad);
            System.out.println(savedOrder);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
