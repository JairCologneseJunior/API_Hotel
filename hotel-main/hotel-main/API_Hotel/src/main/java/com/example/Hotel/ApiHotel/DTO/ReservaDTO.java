package com.example.Hotel.ApiHotel.DTO;

import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import com.example.Hotel.ApiHotel.Models.ReservaDAO;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDTO {

    private Long idReserva;

    private String dataInicio;
    private String dataFim;
    private Integer quantPes;
    private Double preco;

    private ClientDTOSimplificado cliente;

    public ReservaDAO toDAO(){
        return ReservaDAO
                .builder()
                .idReserva(idReserva)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .quantPes(quantPes)
                .preco(preco)
                .cliente(cliente.toDAOSimplificado())
                .build();

    }


}
