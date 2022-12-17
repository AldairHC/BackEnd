package com.example.proyectofinal.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(length = 30)
	private String nombres;
	
	@Column(length = 30)
	private String apellidos;
	
	@Column(length = 50)
	private String direccion;
	
	@Column(length = 15)
	private String telefono;
	
	@Column(length = 30)
	private String tipo_documento;
	
	@Column(length = 20)
	private String numero_documento;

	
	
}
