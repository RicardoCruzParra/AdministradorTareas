package com.administrador.tareas.controller;

import com.administrador.tareas.model.Tarea;
import com.administrador.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarea obtenerTareaPorId(@PathVariable Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con el id: " + id));
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea detallesTarea) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con el id: " + id));

        tarea.setTitulo(detallesTarea.getTitulo());
        tarea.setDescripcion(detallesTarea.getDescripcion());
        tarea.setFechaVencimiento(detallesTarea.getFechaVencimiento());
        tarea.setEstado(detallesTarea.getEstado());

        return tareaRepository.save(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}
