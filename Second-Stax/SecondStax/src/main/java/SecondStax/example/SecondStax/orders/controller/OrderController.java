package SecondStax.example.SecondStax.orders.controller;

import SecondStax.example.SecondStax.FXproduct.model.FXProduct;
import SecondStax.example.SecondStax.orders.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orders.model.Order;
import SecondStax.example.SecondStax.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("http://localhost:4200/")
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

    @GetMapping(value = {"/traderPurchase/{traderID}"})
    public List<Order> getTarderPurchase(@PathVariable("traderID") UUID traderID){
        return orderService.getOrderByTrader(traderID);
    }

    @GetMapping(value = {"/ProviderSells/{providerID}"})
    public List<Order> getProviderSells(@PathVariable("providerID") UUID providerID){
        return orderService.getOrderByProvider(providerID);
    }
}
