package com.example.proyectofinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectofinal.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
