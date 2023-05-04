package com.postwork_dw_java_f2_m2_e8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postwork_dw_java_f2_m2_e8.entity.Empleado;
import com.postwork_dw_java_f2_m2_e8.repository.EmpleadoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository repository;

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleado(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping
    private Flux<Empleado> getEmpleados(){
        return repository.findAll();
    }

    @PostMapping("/update")
    private Mono<Empleado> updateEmpleado(@RequestBody Empleado empleado){
        return repository.save(empleado);
    }
}
