package com.trabajo.pedidos.controller;

import com.trabajo.pedidos.exception.ModelNotFoundException;
import com.trabajo.pedidos.model.Producto;
import com.trabajo.pedidos.model.Proveedor;
import com.trabajo.pedidos.repository.ProductoRepository;
import com.trabajo.pedidos.repository.ProveedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @PostMapping
    void addProductos(@RequestBody Producto producto) {
        productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(!producto.isPresent()) {
            throw new ModelNotFoundException("id-" + id);
        }
        return producto.get();
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        productoRepository.deleteById(id);

    }

    @PutMapping
    public void updateProducto(@RequestBody Producto producto) {
        productoRepository.save(producto);
    }


}
