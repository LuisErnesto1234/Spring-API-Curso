package com.tesis.proyecto.api_tarea.service;

import com.tesis.proyecto.api_tarea.model.Registro;
import com.tesis.proyecto.api_tarea.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> getAllRegistros() {
        return registroRepository.findAll();
    }

    public Optional<Registro> getRegistroById(Long id) {
        return registroRepository.findById(id);
    }

    public Registro saveRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    public boolean deleteRegistroById(Long id) {
        if (registroRepository.existsById(id)) {
            registroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

