package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderRepository {

    public ArrayList<OrderDTO> orders = new ArrayList<>();

    public ArrayList<OrderDTO> all() {
        return this.orders;
    }

    public OrderDTO findById(String uuid) {

        for (OrderDTO orderDTO: this.orders) {
            if(orderDTO.getUuid() == uuid)
                return orderDTO;
        }

        return null;
    }

    public OrderDTO insert(OrderDTO order) {
        this.orders.add(order);
        return order;
    }

    public OrderDTO update(String uuid, OrderDTO order) {

        for(int i=0; i<=this.orders.size();i++){
            if(this.orders.get(i).getUuid() == uuid){
                this.orders.set(i, order);
                break;
            }
        }

        return order;
    }

    public void delete(String uuid) {
        for (OrderDTO orderDTO: this.orders) {
            if(orderDTO.getUuid() == uuid)
                this.orders.remove(orderDTO);
        }
    }

}
