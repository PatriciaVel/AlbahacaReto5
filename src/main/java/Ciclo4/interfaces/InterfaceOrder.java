/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ciclo4.interfaces;

import Ciclo4.modelo.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Acer
 */
public interface InterfaceOrder extends CrudRepository<Order, Integer> {
    
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
}
