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

import com.example.proyectofinal.dao.ProductoRepository;
import com.example.proyectofinal.entity.Producto;
import com.example.proyectofinal.excepciones.NotFoundException;



@RestController
@RequestMapping("api/productos")
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	 @GetMapping
	  List<Producto> listar() {
	    return productoRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Producto guardar(@RequestBody Producto producto) {
	    return productoRepository.save(producto);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Producto listarById(@PathVariable Long id) {
	    
	    return productoRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Producto actualizar(@RequestBody Producto newProducto, @PathVariable Long id) {
	    
	    return productoRepository.findById(id)
	      .map(producto -> {
	    	  producto.setNombre((newProducto.getNombre()));
	    	  producto.setDescripcion((newProducto.getDescripcion()));
	    	  producto.setImagen((newProducto.getImagen()));
	    	  producto.setPrecio((newProducto.getPrecio()));
	    	  producto.setCantidad((newProducto.getCantidad()));
	    	  producto.setCategoria((newProducto.getCategoria()));
	    	  producto.setProveedor((newProducto.getProveedor()));
	        return productoRepository.save(producto);
	      })
	      .orElseGet(() -> {
	    	  newProducto.setIdProducto(id);
	        return productoRepository.save(newProducto);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  productoRepository.deleteById(id);
	  }
}
