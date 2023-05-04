package com.postwork_dw_java_f2_m2_e8.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.postwork_dw_java_f2_m2_e8.entity.Empleado;

@Repository
public interface EmpleadoRepository extends  ReactiveMongoRepository<Empleado, String>{
}
