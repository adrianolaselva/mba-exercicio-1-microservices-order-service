package br.com.fiap.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private String uuid;
    private String description;
    private BigDecimal price;
}
