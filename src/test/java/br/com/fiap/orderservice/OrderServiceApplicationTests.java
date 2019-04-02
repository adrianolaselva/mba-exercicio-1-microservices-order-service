package br.com.fiap.orderservice;

import br.com.fiap.orderservice.controllers.OrderController;
import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.dto.OrderItemDTO;
import br.com.fiap.orderservice.dto.PaymentDTO;
import br.com.fiap.orderservice.enums.Brand;
import br.com.fiap.orderservice.enums.TransactionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void orderNotFound() throws Exception {
		mvc.perform(get("/orders/e442a9e68eb2d051adcc6af6f8a56c54c92279bf")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void entityNotFoundExceptionFound() throws Exception {

		ArrayList<OrderItemDTO> itens = new ArrayList<>();
		itens.add(new OrderItemDTO("item 1", BigDecimal.valueOf(10)));

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writeValueAsString(new OrderDTO(
				"adrianolaselva@gmail.com",
				"Adriano Moreira La Selva",
				"Rua amélia franco, 276",
				1,
				BigDecimal.valueOf(10),
				Calendar.getInstance().getInstance(),
				new PaymentDTO(
						Brand.MASTERCARD,
						TransactionType.CREDIT,
						"",
						"10/22",
						"333",
						BigDecimal.valueOf(10)
				),
				itens
		));

		mvc.perform(put("/orders/e442a9e68eb2d051adcc6af6f8a56c54c92279bf")
				.content(jsonInString)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

}
