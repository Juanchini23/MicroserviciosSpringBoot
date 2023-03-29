package com.microservicio.calificacion.controller;

import com.microservicio.calificacion.entity.Calificacion;
import com.microservicio.calificacion.service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
@RequiredArgsConstructor
public class CalificacionController {

    private final CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.create(calificacion));
    }

    @PutMapping("/{calificacionId}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable("calificacionId") String calificacionId,
                                                               @RequestParam Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.update(calificacionId, calificacion));
    }

    @DeleteMapping("/{calificacionId}")
    public void eliminarCalificacion(@PathVariable("calificacionId") String calificacionId){
        calificacionService.delete(calificacionId);
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> listarCalificaciones(){
        return ResponseEntity.ok(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuarioId(@PathVariable("usuarioId") String usuarioId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByUsuarioId(usuarioId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorHotelId(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByHotelId(hotelId));
    }
}
