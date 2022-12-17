package com.example.proyectofinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 100)
	private String descripcion;
	
	private String imagen;
	
	private Double precio;
	
	private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	@ManyToOne
    @JoinColumn(name = "idProveedor")
	private Proveedor proveedor;
	

}
