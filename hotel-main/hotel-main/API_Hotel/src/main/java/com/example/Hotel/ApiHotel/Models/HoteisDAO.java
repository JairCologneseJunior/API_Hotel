package com.example.Hotel.ApiHotel.Models;


import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity(name = "Hotel")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class HoteisDAO {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String localizacao;

    private Integer quantidadeQuarto;
    private Double pagamento;
    private String infoPagamento;
    private String infoOperacinal;

    public HoteisDTO toDTO (){

        return HoteisDTO.builder()
                .id(id)
                .nome(nome)
                .localizacao(localizacao)
                .quantidadeQuarto(quantidadeQuarto)
                .pagamento(pagamento)
                .infoPagamento(infoPagamento)
                .infoOperacinal(infoOperacinal)
                .build();
    }




}
