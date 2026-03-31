package com.practicos.ejercicio2.controllers;

import com.practicos.ejercicio2.models.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    private void validarPaciente(Paciente paciente){
        if (paciente == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe enviar los datos del paciente.");
        }

        if (paciente.getDni() == null || paciente.getDni() < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe ingresar el DNI y tiene que ser mayor a 0.");
        }

        if (paciente.getNombre() == null || paciente.getNombre().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe ingresar el nombre del paciente,");
        }

        if (paciente.getApellido() == null || paciente.getApellido().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe ingresar el apellido del paciente,");
        }

        if (paciente.getFechaNacimiento() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe ingresar la fecha de nacimiento del paciente,");
        }
    }
}
