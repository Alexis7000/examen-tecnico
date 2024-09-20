package com.tarea.gestionTarea.service;

import com.tarea.gestionTarea.entity.Tarea;
import com.tarea.gestionTarea.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public Tarea createTarea(Tarea tarea) {
        if (tarea.getTitulo() == null || tarea.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título de la tarea no puede estar vacío.");
        }
        try {
            return tareaRepository.save(tarea);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error al guardar la tarea en la base de datos.", e);
        }
    }
}
