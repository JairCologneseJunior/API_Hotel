package com.example.Hotel.ApiHotel.Controller;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.ReservaDAO;
import com.example.Hotel.ApiHotel.DTO.ReservaDTO;

import com.example.Hotel.ApiHotel.repository.ClientRepository;
import com.example.Hotel.ApiHotel.repository.ReservaRepository;
import com.example.Hotel.ApiHotel.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/{idCliente}/reservas")
    public ResponseEntity<ReservaDTO> addReserva(@PathVariable Long idCliente,
                                                 @RequestBody ReservaDTO r) {
        return reservaService.adicionarReserva(idCliente,r);
    }

    @PutMapping("/reservas/{idReserva}/atualizar")
    public ResponseEntity<ReservaDTO> updateReserva(@PathVariable Long idReserva,
                                                    @RequestBody ReservaDTO r) {
        return reservaService.atualizarReserva(idReserva, r);
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaDTO>> getAllReserva() {
        return reservaService.obterReservas();
    }


    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> idreserva(Long id) {
        return reservaService.ObterReserva(id);
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> deleteReservaById(@PathVariable ("id") Long id) {
        return reservaService.deletarReserva(id);
    }


}

