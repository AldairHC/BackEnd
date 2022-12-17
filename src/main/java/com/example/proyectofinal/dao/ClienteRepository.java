package com.example.proyectofinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyectofinal.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
