package com.example.holamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResttController {
    @GetMapping("/")

    public String comienzo (){
        log.info("Estoy ejecutando el controller rest");
        log.debug("Mas Informacion");
        return "Hola Mundo desde Spring Boot!";
    }
}
