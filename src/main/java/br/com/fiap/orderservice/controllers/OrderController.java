package br.com.fiap.orderservice.controllers;

import br.com.fiap.orderservice.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("orders")
public class OrderController {

    @GetMapping()
    public ResponseEntity<ArrayList<OrderDTO>> all(){

        log.info("All orders");

        ArrayList<OrderDTO> orders = new ArrayList<>();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(value = "uuid", required = true) String uuid){

        log.info("Load order {}", uuid);

        OrderDTO orderDTO = new OrderDTO();

        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO){

        log.info("Save order {}", orderDTO);

        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrderDTO> update(@PathVariable("uuid") String uuid, @RequestBody OrderDTO orderDTO){

        log.info("Update order {} {}", uuid, orderDTO);

        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<OrderDTO> delete(@PathVariable("uuid") String uuid){

        log.info("Delete order {}", uuid);

        return new ResponseEntity(uuid, HttpStatus.OK);
    }

}
