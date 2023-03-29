package com.microservicio.calificacion.service.impl;

import com.microservicio.calificacion.entity.Calificacion;
import com.microservicio.calificacion.exceptions.ResourceNotFoundException;
import com.microservicio.calificacion.repository.CalificacionRepository;
import com.microservicio.calificacion.service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository calificacionRepository;

    @Override
    public Calificacion create(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion update(String calificacionId, Calificacion calificacion) {
        if(!calificacionRepository.existsById(calificacionId)) throw new ResourceNotFoundException("Calificacion no encontrada");
        return calificacionRepository.save(calificacion);
    }

    @Override
    public void delete(String calificacionId) {
        if(!calificacionRepository.existsById(calificacionId)) throw new ResourceNotFoundException("Calificacion no encontrada");
        calificacionRepository.deleteById(calificacionId);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }
}
