package com.postwork_dw_java_f2_m2_e8.repository;

import com.postwork_dw_java_f2_m2_e8.models.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "com.postwork_dw_java_f2_m2_e8")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MateriaRepositoryTest {

    @Autowired
    private MateriaRepository materiaRepository;

    /* Este medoto borra la base de datos antes de cada prueba pero esta desahilitada para tener
        datos para posteriores pruebas
    @BeforeAll
    void cleanDatabase() {
        materiaRepository.deleteAll();
    }
    */

    @Test
    @DisplayName("Guardar Materias")
    void guardarMaterias() {
        Materia materia = new Materia();
        materia.setNombre("Java SE Fundamentals II");
        materia = materiaRepository.save(materia);
        assertNotNull(materia.getId());

    }
}