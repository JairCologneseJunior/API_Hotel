package com.example.Hotel.ApiHotel.Models;

import  com.example.Hotel.ApiHotel.DTO.EnderecoDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Embeddable
public class EnderecoDAO {
    private Integer numero;
    private String endereco;
    private String cidade;
    private String estado;
    private String pais;

    public  EnderecoDTO toDTO (){
        return EnderecoDTO.builder()
                .numero(numero)
                .endereco(endereco)
                .cidade(cidade)
                .estado(estado)
                .pais(pais)
                .build();
    }


    public void setid() {
    }
}


