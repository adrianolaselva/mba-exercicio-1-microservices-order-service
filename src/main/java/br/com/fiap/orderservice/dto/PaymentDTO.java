package br.com.fiap.orderservice.dto;

//Crie um endpoint chamado findById que receba um id do pedido e retorne
//        objeto DTO Order com os seguintes atributos caso encontrado. email, Nome
//        completo e shipping address, id do pedido, descrição de cada item do pedido,
//        quantidade de itens do pedido, preço unitário de cada item, preço total do
//        pagamento, forma de pagamento, data do pedido e status do pedido. Adicione
//        também os atributos de pagamento como id da transação, número do cartão,

import br.com.fiap.orderservice.enums.Brand;
import br.com.fiap.orderservice.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Brand brand;
    private String cardNumber;
    private String expDate;
    private String cvv;
    private BigDecimal price;
}
