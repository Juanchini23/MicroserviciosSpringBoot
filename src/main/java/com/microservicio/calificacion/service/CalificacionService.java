package com.microservicio.calificacion.service;

import com.microservicio.calificacion.entity.Calificacion;

import java.util.List;

public interface CalificacionService {

    Calificacion create(Calificacion calificacion);

    Calificacion update(String calificacionId, Calificacion calificacion);

    void delete(String calificacionId);

    List<Calificacion> getCalificaciones();

    List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionesByHotelId(String hotelId);
}
