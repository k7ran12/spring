package com.example.springboot.controlador;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.springboot.model.Cliente;
import com.example.springboot.repositorio.ClienteRepositorio;

import exception.ResourceNotFoundException;

import java.util.List;



@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/")
public class ClienteControlador {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@GetMapping("clientes")
	public List<Cliente> getCliente(){
		return this.clienteRepositorio.findAll();
	}
	
	@GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId)
            throws ResourceNotFoundException {
        Cliente cliente = clienteRepositorio.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente no existe :: " + clienteId));
        return ResponseEntity.ok().body(cliente);
    }
	
	@PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }
	 
	@DeleteMapping("/clientes/{clienteId}")
	public ResponseEntity<Void> deleteClienteById(@PathVariable long clienteId) {

	    	clienteRepositorio.deleteById(clienteId);

	        return ResponseEntity.ok().build();

	}
	
	@PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
                                                   @RequestBody Cliente clienteDetalle) throws ResourceNotFoundException {
		Cliente cliente = clienteRepositorio.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente :: " + clienteId));

		cliente.setNombre(clienteDetalle.getNombre());
        cliente.setApellido(clienteDetalle.getApellido());
       

        final Cliente updatedCliente = clienteRepositorio.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

	
	
}
