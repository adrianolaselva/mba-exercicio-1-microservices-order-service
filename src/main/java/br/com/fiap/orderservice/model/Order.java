package br.com.fiap.orderservice.model;

import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Order ID")
    private Integer id;

    @ApiModelProperty( notes = "User E-mail", required = true)
    private String email;

    @ApiModelProperty( notes = "The order delivery address", required = true)
    private String deliveryAddress;

    @ApiModelProperty( notes = "The order total amount", required = true)
    private BigDecimal totalAmount;
}
