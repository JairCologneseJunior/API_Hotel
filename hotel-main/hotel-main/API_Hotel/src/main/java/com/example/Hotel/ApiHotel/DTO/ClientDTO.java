package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;

import com.example.Hotel.ApiHotel.Models.ReservaDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private Long id;

    private EnderecoDTO endereco;
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;

    private List<ReservaDTO> reservas;

    public ClientDAO toDAO() {
        List<ReservaDAO> reservaDAO = null;
        if (reservas != null) {
            reservaDAO = reservas.stream()
                    .map(ReservaDTO::toDAO)
                    .collect(Collectors.toList());
        }
        return ClientDAO.builder()
                .id(id)
                .senha(senha)
                .endereco(endereco.toDAO())
                .nome(nome)
                .reservas(reservaDAO)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }
}


