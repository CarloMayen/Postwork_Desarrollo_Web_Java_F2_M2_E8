package com.postwork_dw_java_f2_m2_e8.tool;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;
import com.postwork_dw_java_f2_m2_e8.models.Materia;

public class ReporteCalificacionesTest {
    private static Materia materia = new Materia();
    private static Estudiante e1 = new Estudiante();
    private static Estudiante e2 = new Estudiante();
    private static Estudiante e3 = new Estudiante();
    private static Curso curso = new Curso();
    private static ReporteCalificaciones.Reporte rep1;
    private static ReporteCalificaciones.Reporte rep2;
    private static ReporteCalificaciones.Reporte rep3;
    static{
        materia.setNombre("Java SE II");
        e1.setNombreCompleto("Daniel Mayen");
        e2.setNombreCompleto("Juan Aldama");
        e3.setNombreCompleto("Esteban Ramirez");
        curso.setCiclo("2023");
        curso.setMateria(materia);
        Map<Estudiante, Integer> calfs = new HashMap<>();
        calfs.put(e1, 5);
        calfs.put(e2, 9);
        calfs.put(e3, 2);
        curso.setCalificaciones(calfs);
        rep1 = new ReporteCalificaciones.Reporte(e1.getNombreCompleto(), 5);
        rep2 = new ReporteCalificaciones.Reporte(e2.getNombreCompleto(), 9);
        rep3 = new ReporteCalificaciones.Reporte(e3.getNombreCompleto(), 2);
    }

    @Test
    @DisplayName("Alfabético")
    void testAlfabetico() {
        ReporteCalificaciones reporte = new ReporteCalificaciones();
        assertThat(reporte.alfabetico(curso)).containsExactly(rep1, rep3, rep2);

    }

    @Test
    @DisplayName("Calificación")
    void testCalificacion() {
        ReporteCalificaciones reporte = new ReporteCalificaciones();
        assertThat(reporte.calificacion(curso)).containsExactly(rep2, rep1, rep3);
    }
}
