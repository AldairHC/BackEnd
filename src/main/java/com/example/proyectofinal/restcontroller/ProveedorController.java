package com.example.proyectofinal.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectofinal.dao.ProveedorRepository;
import com.example.proyectofinal.entity.Proveedor;
import com.example.proyectofinal.excepciones.NotFoundException;


@RestController
@RequestMapping("api/proveedor")
@CrossOrigin("*")
public class ProveedorController {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	 @GetMapping
	  List<Proveedor> listar() {
	    return proveedorRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Proveedor guardar(@RequestBody Proveedor proveedor) {
	    return proveedorRepository.save(proveedor);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Proveedor listarById(@PathVariable Long id) {
	    
	    return proveedorRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Proveedor actualizar(@RequestBody Proveedor newProveedor, @PathVariable Long id) {
	    
	    return proveedorRepository.findById(id)
	      .map(proveedor -> {
	    	  proveedor.setNombre((newProveedor.getNombre()));
	    	  proveedor.setDireccion((newProveedor.getDireccion()));
	    	  proveedor.setTelefono((newProveedor.getTelefono()));
	    	  proveedor.setEmail((newProveedor.getEmail()));
	        return proveedorRepository.save(proveedor);
	      })
	      .orElseGet(() -> {
	    	  newProveedor.setIdProveedor(id);
	        return proveedorRepository.save(newProveedor);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  proveedorRepository.deleteById(id);
	  }
	
}
