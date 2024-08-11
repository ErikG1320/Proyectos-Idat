package com.example.demo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Entity.TiendaProductos;
import com.example.demo.Repository.TiendaRepository;

@SpringBootTest
public class IdatApplicationTests {
    @Autowired
    private TiendaRepository repository;

    // private static final Logger logger = LoggerFactory.getLogger(IdatApplicationTests.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(IdatApplicationTests.class);

    @Test
    public void testPasswordEncoding() {
        String rawPassword = "holamundo";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Verifica que las contraseñas no sean iguales
        assertThat(encodedPassword).isNotEqualTo(rawPassword);

        // Verifica que la contraseña encriptada coincida con la contraseña original
        assertThat(passwordEncoder.matches(rawPassword, encodedPassword)).isTrue();

        // Simulación de guardar un usuario
        TiendaProductos usuarioEjemplo = new TiendaProductos("usuario", encodedPassword);
        repository.save(usuarioEjemplo);
    }

    public void save(TiendaProductos usuario) {
        logger.info("Guardando usuario con contraseña encriptada: " + usuario.getPassword());
    }
}
