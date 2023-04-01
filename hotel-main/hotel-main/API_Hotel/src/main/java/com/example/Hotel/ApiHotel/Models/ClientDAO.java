package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;

import com.example.Hotel.ApiHotel.DTO.ClientDTOSimplificado;
import com.example.Hotel.ApiHotel.DTO.EnderecoDTO;

import com.example.Hotel.ApiHotel.DTO.ReservaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClientDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EnderecoDAO endereco;
    @NotEmpty
    private String senha;
    @NotBlank
    @Size(min = 3,max = 25, message = "Apelidos nao são validos")
    private String nome;
    private String sobrenome;
    private String telefone;
    @Email
    private String email;
    private String aniversario;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private List<ReservaDAO> reservas;

    public ClientDTO toDTO() {
        List<ReservaDTO> reservaDTO = null;

        if (reservas != null) {
            reservaDTO = reservas.stream()
                    .map(ReservaDAO::toDTO)
                    .collect(Collectors.toList());
        }

        return ClientDTO.builder()
                .id(id)
                .senha(senha)
                .endereco(endereco.toDTO())
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .reservas(reservaDTO)
                .build();
    }


    public ClientDTOSimplificado toDTOSimplificado() {
        return ClientDTOSimplificado.builder()
                .id(id)
                .senha(senha)
                .nome(nome)
                .endereco(endereco.toDTO())
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }
}