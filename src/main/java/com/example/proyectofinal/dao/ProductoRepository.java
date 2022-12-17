package com.example.proyectofinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectofinal.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
