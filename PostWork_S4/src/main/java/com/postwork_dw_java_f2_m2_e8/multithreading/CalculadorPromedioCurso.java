package com.postwork_dw_java_f2_m2_e8.multithreading;

import com.postwork_dw_java_f2_m2_e8.models.Curso;

public class CalculadorPromedioCurso implements Runnable{
    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso){
        this.curso = curso;
    }

    @Override
    public void run() {
        int nAlumnos = 0;
        for (int item : curso.getCalificaciones().values()) {
            promedio += item;
            nAlumnos++;
        }

        promedio = promedio/nAlumnos;
        System.out.println("Promedio de id " + curso.getId() + " - " + curso.getMateria().getNombre()+ ": " + promedio);
    }

}
