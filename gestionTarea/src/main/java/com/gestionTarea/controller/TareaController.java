package com.tarea.gestionTarea.controller;
import com.tarea.gestionTarea.entity.Tarea;
import com.tarea.gestionTarea.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea) {
        // Deja que el servicio maneje la excepción
        Tarea newTarea = tareaService.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTarea);
    }
}
