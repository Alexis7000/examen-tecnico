package com.tarea.gestionTarea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarea.gestionTarea.entity.Tarea;
import com.tarea.gestionTarea.service.TareaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TareaController.class)
public class TareaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TareaService tareaService;

    @Autowired
    private ObjectMapper objectMapper;

    // Test para crear una tarea correctamente
    @Test
    public void whenValidInput_thenCreateTarea() throws Exception {
        Tarea tarea = new Tarea("Titulo", "Descripción", "PENDIENTE", LocalDate.now());

        Mockito.when(tareaService.createTarea(Mockito.any(Tarea.class)))
                .thenReturn(tarea);

        mockMvc.perform(post("/tarea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarea)))
                .andExpect(status().isCreated())  // Comprobar que se devuelve el código 201
                .andExpect(jsonPath("$.titulo").value("Titulo"))  // Verificar que el JSON contiene el título
                .andExpect(jsonPath("$.descripcion").value("Descripción"));
    }

    // Test para manejar la excepción IllegalArgumentException
    @Test
    public void whenInvalidInput_thenReturns400AndExceptionMessage() throws Exception {
        Mockito.when(tareaService.createTarea(Mockito.any(Tarea.class)))
                .thenThrow(new IllegalArgumentException("El título de la tarea no puede estar vacío."));

        Tarea invalidTarea = new Tarea(null, "Descripción", "PENDIENTE", LocalDate.now());

        mockMvc.perform(post("/tarea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidTarea)))
                .andExpect(status().isBadRequest())  // Comprobar que devuelve 400 Bad Request
                .andExpect(jsonPath("$.message").value("El título de la tarea no puede estar vacío."));  // Verificar el mensaje de error
    }
}