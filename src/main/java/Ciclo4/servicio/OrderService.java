/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.servicio;

import Ciclo4.modelo.Order;
import Ciclo4.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.create(order);
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                if (order.getId() != null) {
                    orderDb.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    orderDb.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getSalesMan() != null) {
                    orderDb.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orderDb.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orderDb.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(int id) {
        return orderRepository.ordersSalesManByID(id);
    }

    //Reto 4: Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }

    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return orderRepository.ordersSalesManByState(state, id);
    }

}
