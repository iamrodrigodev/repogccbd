package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> listarLibros() {
        return repository.findAllByOrderByIdAsc();
    }

    public Libro registrarLibro(Libro libro) {
        libro.setId(null);
        return repository.save(libro);
    }
}
