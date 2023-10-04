package com.administrador.tareas.service;

import com.administrador.tareas.model.Tarea;
import com.administrador.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll();
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con el id: " + id));
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea detallesTarea) {
        Tarea tarea = obtenerTareaPorId(id);

        tarea.setTitulo(detallesTarea.getTitulo());
        tarea.setDescripcion(detallesTarea.getDescripcion());
        tarea.setFechaVencimiento(detallesTarea.getFechaVencimiento());
        tarea.setEstado(detallesTarea.getEstado());

        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
