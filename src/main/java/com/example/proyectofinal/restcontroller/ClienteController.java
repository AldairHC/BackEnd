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

import com.example.proyectofinal.dao.ClienteRepository;
import com.example.proyectofinal.entity.Cliente;
import com.example.proyectofinal.excepciones.NotFoundException;



@RestController
@RequestMapping("api/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	
	@Autowired
	ClienteRepository clienteRepository;
	
	 @GetMapping
	  List<Cliente> listar() {
	    return clienteRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Cliente guardar(@RequestBody Cliente cliente) {
	    return clienteRepository.save(cliente);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Cliente listarById(@PathVariable Long id) {
	    
	    return clienteRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Cliente actualizar(@RequestBody Cliente newCliente, @PathVariable Long id) {
	    
	    return clienteRepository.findById(id)
	      .map(cliente -> {
	    	  cliente.setNombres((newCliente.getNombres()));
	    	  cliente.setApellidos((newCliente.getApellidos()));
	    	  cliente.setDireccion((newCliente.getDireccion()));
	    	  cliente.setTelefono((newCliente.getTelefono()));
	    	  cliente.setTipo_documento((newCliente.getTipo_documento()));
	    	  cliente.setNumero_documento((newCliente.getNumero_documento()));
	        return clienteRepository.save(cliente);
	      })
	      .orElseGet(() -> {
	    	  newCliente.setIdCliente(id);
	        return clienteRepository.save(newCliente);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  clienteRepository.deleteById(id);
	  }
	
}
