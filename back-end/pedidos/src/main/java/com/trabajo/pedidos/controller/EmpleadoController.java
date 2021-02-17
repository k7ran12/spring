package com.trabajo.pedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Empleado;
import com.trabajo.pedidos.repository.EmpleadoRepository;




@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	private final EmpleadoRepository empleadoRepository;

	public EmpleadoController(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	@GetMapping
    public List<Empleado> getEmpleados() {
		return (List<Empleado>) empleadoRepository.findAll();
    }
    
    
    @PostMapping
    public Empleado addEmpleados(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
	
    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable long id) {
		Optional<Empleado> empleado = empleadoRepository.findById(id);
		if(!empleado.isPresent()) {
			throw new ModelNotFoundException("id-" + id);
		}
        return empleado.get();
    }
    
    @DeleteMapping("/{id}")
	public void deleteEmpleado(@PathVariable("id") Long id) {
		empleadoRepository.deleteById(id);

	}
    
    @PutMapping
	public void updateEmpleado(@RequestBody Empleado empleado) {
		empleadoRepository.save(empleado);
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable(value = "id") Long clienteId,
                                                   @RequestBody Empleado clienteDetalle) throws ModelNotFoundException {
    	Empleado empleado = empleadoRepository.findById(clienteId)
                .orElseThrow(() -> new ModelNotFoundException("No existe el cliente :: " + clienteId));

    	empleado.setNombre(clienteDetalle.getNombre());
    	empleado.setApellido(clienteDetalle.getApellido());
       

        final Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return ResponseEntity.ok(updatedEmpleado);
    }
    
}
