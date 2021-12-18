/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ciclo4.interfaces;

import Ciclo4.modelo.Vegetarian;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Acer
 */
public interface InterfaceVegetarian extends MongoRepository<Vegetarian, String>{
    public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
    public List<Vegetarian>findByDescriptionContainingIgnoreCase(String description);
}
