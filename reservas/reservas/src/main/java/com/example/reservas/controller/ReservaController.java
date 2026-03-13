package com.example.reservas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.model.Reserva;

@RequestMapping("/reservas")
@RestController
public class ReservaController {

    private List<Reserva> reservas = new ArrayList<>();

    @GetMapping
    public List<Reserva> listarReservas(){
        return reservas;
    }

    @GetMapping("/{id}")
    public Reserva obtenerReserva(@PathVariable Long id){

        for(Reserva r : reservas){
            if(r.getId().equals(id)){
                return r;
            }
        }

        return null;
    }

    @PostMapping
    public Reserva agregarReserva(@RequestBody Reserva reserva){

        reserva.setId((long)(reservas.size()+1));
        reservas.add(reserva);

        return reserva;
    }

    @GetMapping("/cancha/{id}")
    public List<Reserva> reservasPorCancha(@PathVariable Long id){

        List<Reserva> resultado = new ArrayList<>();

        for(Reserva r : reservas){
            if(r.getCanchaId().equals(id)){
                resultado.add(r);
            }
        }

        return resultado;
    }

}
