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

import com.example.proyectofinal.dao.VentaRepository;
import com.example.proyectofinal.entity.Venta;
import com.example.proyectofinal.excepciones.NotFoundException;


@RestController
@RequestMapping("api/venta")
@CrossOrigin("*")
public class VentaController {
	@Autowired
	VentaRepository ventaRepository;
	
	 @GetMapping
	  List<Venta> listar() {
	    return ventaRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Venta guardar(@RequestBody Venta venta) {
	    return ventaRepository.save(venta);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Venta listarById(@PathVariable Long id) {
	    
	    return ventaRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Venta actualizar(@RequestBody Venta newVenta, @PathVariable Long id) {
	    
	    return ventaRepository.findById(id)
	      .map(venta -> {
			venta.setDescripcion(newVenta.getDescripcion());
			venta.setCliente(newVenta.getCliente());
			venta.setProducto(newVenta.getProducto());
			venta.setEmpleado(newVenta.getEmpleado());
	    	  venta.setCantidad(newVenta.getCantidad());
	        return ventaRepository.save(venta);
	      })
	      .orElseGet(() -> {
	    	  newVenta.setIdVenta(id);
	        return ventaRepository.save(newVenta);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  ventaRepository.deleteById(id);
	  }
	
}
