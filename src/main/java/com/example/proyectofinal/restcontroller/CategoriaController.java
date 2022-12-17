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

import com.example.proyectofinal.dao.CategoriaRepository;
import com.example.proyectofinal.entity.Categoria;
import com.example.proyectofinal.excepciones.NotFoundException;


@RestController
@RequestMapping("api/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	 @GetMapping
	  List<Categoria> listar() {
	    return categoriaRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Categoria guardar(@RequestBody Categoria categoria) {
	    return categoriaRepository.save(categoria);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Categoria listarById(@PathVariable Long id) {
	    
	    return categoriaRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Categoria actualizar(@RequestBody Categoria newCategoria, @PathVariable Long id) {
	    
	    return categoriaRepository.findById(id)
	      .map(categoria -> {
	    	  categoria.setNombre(newCategoria.getNombre());
	        return categoriaRepository.save(categoria);
	      })
	      .orElseGet(() -> {
	    	  newCategoria.setIdCategoria(id);
	        return categoriaRepository.save(newCategoria);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  categoriaRepository.deleteById(id);
	  }
}
