package com.postwork_dw_java_f2_m2_e8.reactive;

import java.util.stream.Collectors;

import com.postwork_dw_java_f2_m2_e8.models.Curso;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CalcularPromedioCursoRx {
    public Mono<Double> promedio(Curso curso) {
        return Flux.fromStream(curso.getCalificaciones().values().parallelStream())
                .collect(Collectors.averagingDouble(c -> (double) c));
    }
}
