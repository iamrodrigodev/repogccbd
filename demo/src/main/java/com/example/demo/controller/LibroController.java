package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return service.listarLibros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Libro registrarLibro(@Valid @RequestBody Libro libro) {
        return service.registrarLibro(libro);
    }
}
