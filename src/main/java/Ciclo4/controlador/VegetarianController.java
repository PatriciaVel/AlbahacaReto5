/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo4.controlador;

import Ciclo4.modelo.Vegetarian;
import Ciclo4.servicio.VegetarianService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Acer
 */
@RestController
@RequestMapping("/api/vegetarian")
@CrossOrigin("*")
public class VegetarianController {

    @Autowired
    private VegetarianService accessoryService;

    @GetMapping("/all")
    public List<Vegetarian> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Vegetarian> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian create(@RequestBody Vegetarian gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian update(@RequestBody Vegetarian gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Vegetarian> getByPrice(@PathVariable("price") double price) {
        return accessoryService.productByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Vegetarian> getByByDescriptionContainingIgnoreCase(@PathVariable("description") String description) {
        return accessoryService.getByDescriptionContainingIgnoreCase(description);
    }
}
