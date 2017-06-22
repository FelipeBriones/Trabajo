package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sentrauser3075 on 22-06-2017.
 */
@Component
public class UnServicio {

    public String hacerAlgo(String alguna, String cosa) {
        System.out.println(String.format("en el servicio %s %s", alguna, cosa));
        return "alguna cosa";
    }

    @Loggeable("cosa, fecha")
    public String hacerOtraCosa(String otra, String cosa, Date fecha){
        System.out.println(String.format("en el servicio otra %s %s %s", otra, cosa, fecha));
        return "otra cosa";
    }
}
