package com.example.demo.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

import jakarta.validation.Valid;

@RestController
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> consultarProducto(@PathVariable("id") int id) {
        return ResponseEntity.of(service.consultarProducto(id));
    }

    @PostMapping("/productos/nuevo")
    public ResponseEntity<Producto> registrarProducto(@Valid @RequestBody Producto producto) {
        Producto registrado = service.registrarProducto(producto);
        return ResponseEntity.created(URI.create("/producto/" + registrado.getId())).body(registrado);
    }
}
