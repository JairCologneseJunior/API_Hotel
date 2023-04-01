package com.example.Hotel.ApiHotel.DTO;

import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.ReservaDAO;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTOSimplificado {

    private Long id;

    private EnderecoDTO endereco;
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;

    public ClientDAO toDAOSimplificado() {
        return ClientDAO.builder()
                .id(id)
                .endereco(endereco.toDAO())
                .senha(senha)
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }

}

