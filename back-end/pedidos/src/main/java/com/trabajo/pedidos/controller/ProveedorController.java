package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Proveedor;
import com.trabajo.pedidos.repository.ProveedorRepository;

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

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping
    public List<Proveedor> getProveedores() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @PostMapping
    void addProveedores(@RequestBody Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedor(@PathVariable long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if(!proveedor.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return proveedor.get();
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable("id") Long id) {
        proveedorRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public void updateProveedor(@RequestBody Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

}


