package SecondStax.example.SecondStax.orderPlacement.controller;

import SecondStax.example.SecondStax.orderPlacement.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orderPlacement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PutMapping(value = {"/rejectOrder/{orderId}"})
    public void RejectOrders(@PathVariable("orderId") UUID orderId){
        try{
            String rejectedOrder = orderService.cancelOrder(orderId);
            System.out.println(rejectedOrder);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PutMapping(value = {"/acceptOrder/{orderId}"})
    public void AcceptOrders(@PathVariable("orderId") UUID orderId){
        try{
            String acceptedOrder = orderService.approveOrder(orderId);
            System.out.println(acceptedOrder);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
