package br.com.fiap.orderservice.controllers;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.exceptions.OrderNotFoundException;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderRepository orderRepository;

//    @Autowired
    public OrderController() {
        this.orderRepository = new OrderRepository();
    }

    @GetMapping()
    public ResponseEntity<ArrayList<OrderDTO>> all(){

        log.info("All orders");

        ArrayList<OrderDTO> orders = this.orderRepository.all();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(value = "uuid", required = true) String uuid) throws OrderNotFoundException {

        log.info("Load order {}", uuid);

        OrderDTO order = this.orderRepository.findById(uuid);

        if(order == null)
            throw new OrderNotFoundException(OrderDTO.class, "uuid", uuid);


        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO){

        log.info("Save order {}", orderDTO);

        OrderDTO order = this.orderRepository.insert(orderDTO);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrderDTO> update(@PathVariable("uuid") String uuid, @RequestBody OrderDTO orderDTO) throws OrderNotFoundException {

        log.info("Update order {} {}", uuid, orderDTO);

        OrderDTO order = this.orderRepository.findById(uuid);

        if(order == null)
            throw new OrderNotFoundException(OrderDTO.class, "uuid", uuid);

        order = this.orderRepository.update(uuid, order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<OrderDTO> delete(@PathVariable("uuid") String uuid) throws OrderNotFoundException {

        log.info("Delete order {}", uuid);

        OrderDTO order = this.orderRepository.findById(uuid);

        if(order == null)
            throw new OrderNotFoundException(OrderDTO.class, "uuid", uuid);

        this.orderRepository.delete(uuid);

        return new ResponseEntity(uuid, HttpStatus.OK);
    }

}
