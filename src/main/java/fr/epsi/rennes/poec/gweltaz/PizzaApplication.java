package fr.epsi.rennes.poec.gweltaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "fr.epsi.rennes.poec.gweltaz")
public class PizzaApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(PizzaApplication.class, args);


    }
}
