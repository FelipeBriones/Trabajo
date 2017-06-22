package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by sentrauser3075 on 22-06-2017.
 */
@RestController
public class UnController {

    @Autowired
    private UnServicio servicio;

    @GetMapping("/un/endpoint")
    public String unEndpoint(){
        System.out.println("en el endpoint");
        return servicio.hacerAlgo("soy alguna", "soy cosa") + servicio.hacerOtraCosa("soy la otra", "soy la cosa", new Date());
    }
}
