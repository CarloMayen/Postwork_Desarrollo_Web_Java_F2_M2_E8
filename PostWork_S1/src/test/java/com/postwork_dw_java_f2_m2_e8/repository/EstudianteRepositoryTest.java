package com.postwork_dw_java_f2_m2_e8.repository;

import com.postwork_dw_java_f2_m2_e8.models.Estudiante;
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
class EstudianteRepositoryTest {

    @Autowired
    private EstudianteRepository estudianteRepository;

    /*
    @BeforeAll
    void cleanDatabase() {
        estudianteRepository.deleteAll();
    }
    */
    @Test
    @DisplayName("Guardar Estudiante")
    void guardarEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Roberto Carlo Mayen Vazquez");
        estudiante = estudianteRepository.save(estudiante);
        assertNotNull(estudiante.getId());
    }

}