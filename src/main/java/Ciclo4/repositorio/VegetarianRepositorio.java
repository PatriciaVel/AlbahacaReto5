/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.repositorio;

import Ciclo4.interfaces.InterfaceVegetarian;
import Ciclo4.modelo.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository
public class VegetarianRepositorio {

    @Autowired
    private InterfaceVegetarian repository;

    public List<Vegetarian> getAll() {
        return repository.findAll();
    }

    public Optional<Vegetarian> getClothe(String reference) {
        return repository.findById(reference);
    }

    public Vegetarian create(Vegetarian clothe) {
        return repository.save(clothe);
    }

    public void update(Vegetarian clothe) {
        repository.save(clothe);
    }

    public void delete(Vegetarian clothe) {
        repository.delete(clothe);
    }

    public List<Vegetarian> productByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }

    public List<Vegetarian> getByDescriptionContainingIgnoreCase(String description) {
        return repository.findByDescriptionContainingIgnoreCase(description);
    }

}
