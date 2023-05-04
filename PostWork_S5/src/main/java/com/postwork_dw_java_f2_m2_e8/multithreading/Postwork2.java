package com.postwork_dw_java_f2_m2_e8.multithreading;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Materia;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;

public class Postwork2 {

    private static Curso crearCurso(Random r, String nombre, Long id) {
        Curso curso = new Curso();
        Materia materia = new Materia();
        Estudiante estudiante;

        curso.setId(id);
        materia.setNombre(nombre);
        curso.setMateria(materia);

        Map<Estudiante, Integer> cals = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            estudiante = new Estudiante();
            estudiante.setId((long) i);
            estudiante.setNombreCompleto("E" + i);
            cals.put(estudiante, r.nextInt(10));
        }

        curso.setCalificaciones(cals);
        return curso;
    }

    public static void main(String[] args) {
        Random r = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        Curso[] cursos = new Curso[] {
                crearCurso(r, "Java SE I", 1L),
                crearCurso(r, "Java SE II", 2L),
                crearCurso(r, "Java Backend I", 3L),
                crearCurso(r, "Java Backend II", 4L),
                crearCurso(r, "Mysql I", 5L)

        };

        for (Curso curso : cursos) {
            pool.execute(new CalculadorPromedioCurso(curso));
        }
        pool.shutdown();
    }
}
