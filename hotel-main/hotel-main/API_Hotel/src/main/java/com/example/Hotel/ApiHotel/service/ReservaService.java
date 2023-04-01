package com.example.Hotel.ApiHotel.service;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.DTO.ReservaDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.ReservaDAO;
import com.example.Hotel.ApiHotel.repository.ClientRepository;
import com.example.Hotel.ApiHotel.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<ReservaDTO> adicionarReserva(Long idCliente, ReservaDTO r) {
        var reserva = new ReservaDAO();
        r.setCliente(busrcarIdCliente(idCliente).toDTOSimplificado());

        var reserva2 = reservaRepository.save(r.toDAO());
        return new ResponseEntity<ReservaDTO>(reserva2.toDTO(), HttpStatus.CREATED);
    }

    public ClientDAO busrcarIdCliente(Long idCliente){
        return clientRepository.findById(idCliente).orElseThrow(()->new EntityNotFoundException("erro"));
    }

    public ResponseEntity<ReservaDTO> atualizarReserva(Long idReserva, ReservaDTO r) {
        r.setIdReserva(idReserva);
        ReservaDAO reservaUpdate = reservaRepository.save(r.toDAO());
        return new ResponseEntity<ReservaDTO>(reservaUpdate.toDTO(), HttpStatus.OK);
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaDTO>> obterReservas() {
        List<ReservaDAO> reservas = reservaRepository.findAll();
        List<ReservaDTO> reservaDTOs = new ArrayList<>();
        for (ReservaDAO reservaDAO : reservas) {
            reservaDTOs.add(reservaDAO.toDTO());
        }
        return ResponseEntity.ok().body(reservaDTOs);
    }

    public ResponseEntity<ReservaDTO> ObterReserva(Long id) {
        Optional<ReservaDAO> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            return new ResponseEntity<ReservaDTO>(reserva.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ReservaDTO> deletarReserva(@PathVariable Long id) {
        ReservaDAO reserva = new ReservaDAO();
        reserva.setIdReserva(id);
        reservaRepository.delete(reserva);
        return ResponseEntity.noContent().build();
    }


}