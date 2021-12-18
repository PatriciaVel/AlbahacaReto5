/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ciclo4.interfaces;

import Ciclo4.modelo.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
/**
 *
 * @author Acer
 */
public interface InterfaceUser extends MongoRepository<User,Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    List<User> findBybirthtDay(Date date);
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
