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
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;

	private String fecha;
	
	@Column(length = 100)
	private String descripcion;
	
	private Double precio;
	
	private Integer cantidad;
	
	private Double total;

    @ManyToOne
    @JoinColumn(name = "idProducto")
	private Producto producto;
	
	@ManyToOne
    @JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name = "idEmpleado")
	private Empleado empleado;
	

}
