package com.postwork_dw_java_f2_m2_e8.tool;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.postwork_dw_java_f2_m2_e8.models.Curso;
import com.postwork_dw_java_f2_m2_e8.models.Estudiante;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
public class ReporteCalificaciones {
    @Data
    @RequiredArgsConstructor
    static class Reporte {
        private final String nombreEstudiante;
        private final Integer cal;
    }

    private List<Reporte> generaLista(Map<Estudiante, Integer> calfs, Comparator<Reporte> comparator) {
        return calfs.entrySet().stream()
                .map(e -> new Reporte(e.getKey().getNombreCompleto(), e.getValue()))
                .sorted(comparator)
                .collect(Collectors.toList());

    }

    public List<Reporte> alfabetico(Curso curso){
        return generaLista(curso.getCalificaciones(), (c1, c2)-> c1.getNombreEstudiante().compareTo(c2.getNombreEstudiante()));
    }

    public List<Reporte> calificacion(Curso curso){
        return generaLista(curso.getCalificaciones(), (c1, c2 )-> c2.getCal().compareTo(c1.getCal()));
    }
}
