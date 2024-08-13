package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Entity.TiendaMicas;

@SpringBootTest
public class IdatApplicationTests {

    // private static final Logger logger = LoggerFactory.getLogger(IdatApplicationTests.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
public void testPasswordEncoding() {
    String rawPassword = "Mimundosinella-Armonia10";
    String encodedPassword = passwordEncoder.encode(rawPassword);

    assertThat(encodedPassword).isNotEqualTo(rawPassword);
    assertThat(passwordEncoder.matches(rawPassword, encodedPassword)).isTrue();

    TiendaMicas usuarioEjemplo = new TiendaMicas("usuario", encodedPassword);
    
    // Impresión de la contraseña encriptada en la consola
    System.out.println("Contraseña encriptada: " + usuarioEjemplo.getContraseña());
    // Simulación de imprimir un usuario localmente en la consola
    System.out.println("Usuario: " + usuarioEjemplo);
    System.out.println(encodedPassword);
}
}