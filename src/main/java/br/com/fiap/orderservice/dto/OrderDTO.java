package br.com.fiap.orderservice.dto;

//Crie um endpoint chamado findById que receba um id do pedido e retorne
//        objeto DTO Order com os seguintes atributos caso encontrado. email, Nome
//        completo e shipping address, id do pedido, descrição de cada item do pedido,
//        quantidade de itens do pedido, preço unitário de cada item, preço total do
//        pagamento, forma de pagamento, data do pedido e status do pedido. Adicione
//        também os atributos de pagamento como id da transação, número do cartão,

import br.com.fiap.orderservice.enums.OrderStatus;
import br.com.fiap.orderservice.enums.PaymentMethod;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String uuid;
    private String email;
    private String fullName;
    private String shippingAddress;
    private Integer quantity;
    private BigDecimal price;
    private PaymentMethod paymentMethod;
    private OrderStatus status;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar date;
    private PaymentDTO payment = new PaymentDTO();
    private ArrayList<OrderItemDTO> items = new ArrayList<>();
}
