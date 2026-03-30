package com.practicos.ejercicio2.controllers;

import com.practicos.ejercicio2.models.Paciente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private List<Paciente> pacientes = new ArrayList<>();
    private List<Paciente> pacientesMenores = new ArrayList<>();

    @PostMapping
    public Paciente agregarPaciente(@RequestBody Paciente paciente){
        pacientes.add(paciente);
        return paciente;
    }

    @GetMapping
    public List<Paciente> obtenerPacientes(){
        return pacientes;
    }

    //Agregar función que distinga pacientes menores de edad aquí-->

    //<-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-- <-

    @GetMapping("/menores")
    public List<Paciente> obtenerPacientesMenores(){
        return pacientesMenores;
    }
}
