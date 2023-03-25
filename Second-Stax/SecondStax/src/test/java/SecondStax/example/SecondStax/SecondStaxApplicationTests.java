package SecondStax.example.SecondStax;

import SecondStax.example.SecondStax.orders.dto.OrderPayLoad;
import SecondStax.example.SecondStax.orders.model.Order;
import SecondStax.example.SecondStax.orders.repository.OrderRepository;
import SecondStax.example.SecondStax.orders.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class SecondStaxApplicationTests {
	@Autowired
	private OrderService orderService;
	@MockBean
	private OrderRepository orderRepository;

	@MockBean
	Order order;

	@Test
	public void placeOrder_validOrderRequest_orderSavedInDatabase(){
		OrderPayLoad request = new OrderPayLoad(234,UUID.fromString("123e4567-e89b-12d3-a456-426614174019"), UUID.fromString("123e4567-e89b-12d3-a456-426614174019"),UUID.fromString("123e4567-e89b-12d3-a456-426614173119"));

		orderService.saveOrder(request);

		Mockito.verify(orderRepository, Mockito.times(1)).save(any());
	}

	@Test
	public void placeOrder_InvalidvalidOrderRequest_orderRejected(){
		UUID traderId = UUID.randomUUID();
		UUID productId = UUID.randomUUID();
		OrderPayLoad request = new OrderPayLoad(234,UUID.fromString("123e4567-e89b-12d3-a456-426614174019"),productId,traderId);

		assertThrows(NoSuchElementException.class, () -> {orderService.saveOrder(request);});
	}

	@Test
	public void RejectOrder_orderRejected_orderStatusIsRejected(){

		Mockito.doReturn(Optional.of(new Order())).when(orderRepository).findById(UUID.fromString("89a70d7e-b68d-4943-893d-a534fd087843"));
		orderService.cancelOrder(UUID.fromString("89a70d7e-b68d-4943-893d-a534fd087843"));

		Mockito.verify(orderRepository, Mockito.times(1)).save(any());
		//assertThat(order.getStatus()).isEqualTo(2);
	}

	@Test
	public void RejectOrder_orderDoesNotExist_requestFail(){
		assertThrows(NoSuchElementException.class, () -> {orderService.cancelOrder(UUID.randomUUID());});
	}

	@Test
	public void AcceptOrder_invalidorder_requestFail(){
		assertThrows(NoSuchElementException.class, () -> {orderService.approveOrder(UUID.randomUUID());});
	}


}

