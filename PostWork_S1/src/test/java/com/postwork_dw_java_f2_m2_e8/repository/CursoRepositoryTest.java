package com.postwork_dw_java_f2_m2_e8.repository;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "com.postwork_dw_java_f2_m2_e8")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @BeforeAll
    void borrarDataBases() {
        cursoRepository.deleteAll();
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();
    }

    @Test
    @DisplayName("Guardar cursos")
    void guardarCursos() {
        Curso curso = new Curso();
        curso.setCiclo("2023");
        Materia m = new Materia();
        m.setId(2L);
        curso.setMateria(m);
        curso = cursoRepository.save(curso);
        assertNotNull(curso.getId());
    }

    @Test
    @DisplayName("Guardar un registro completo con calificaciones")
    void pruebaCursos() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Estudiante 1");
        estudianteRepository.save(estudiante);

        Materia materia = new Materia();
        materia.setNombre("Materia 1");
        materiaRepository.save(materia);

        Curso curso = new Curso();
        curso.setCiclo("2023");
        curso.setMateria(materia);
        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante, 8);
        curso.setCalificaciones(calificaciones);
    }



}