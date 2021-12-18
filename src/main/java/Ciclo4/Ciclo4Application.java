package Ciclo4;

import Ciclo4.interfaces.InterfaceOrder;
import Ciclo4.interfaces.InterfaceUser;
import Ciclo4.interfaces.InterfaceVegetarian;
import Ciclo4.repositorio.OrderRepositorio;
import Ciclo4.repositorio.UserRepositorio;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Ciclo4Application implements CommandLineRunner{
    @Autowired
    private InterfaceVegetarian interfaceVegetarian;
    @Autowired  
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;
    
    
    @Autowired
    private UserRepositorio userRepositorio;
    @Autowired
    private OrderRepositorio orderRepositorio;
    
    @Autowired
    private MongoTemplate mongoTemplate;


    public static void main(String[] args) {
        SpringApplication.run(Ciclo4Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfaceVegetarian.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }
        

}
