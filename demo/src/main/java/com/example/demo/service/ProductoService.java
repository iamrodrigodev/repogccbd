package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Optional<Producto> consultarProducto(int id) {
        return repository.findById(id);
    }

    public Producto registrarProducto(Producto producto) {
        producto.setId(null);
        return repository.save(producto);
    }
}
