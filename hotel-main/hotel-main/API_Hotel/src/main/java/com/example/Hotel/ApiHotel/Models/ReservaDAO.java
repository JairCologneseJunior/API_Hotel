package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.QuartosDTO;
import com.example.Hotel.ApiHotel.DTO.ReservaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity(name = "Reserva")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ReservaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private String dataInicio;
    private String dataFim;
    private int quantPes;
    private double preco;

    @ManyToOne
    private ClientDAO cliente;

    public ReservaDTO toDTO() {
        return ReservaDTO.builder()
                .idReserva(idReserva)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .quantPes(quantPes)
                .preco(preco)
                .cliente(cliente.toDTOSimplificado())
                .build();
    }

}
