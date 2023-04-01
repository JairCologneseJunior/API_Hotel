package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.EnderecoDAO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO {


    private String endereco;
    private Integer numero;
    private String cidade;
    private String estado;
    private String pais;
    
    public EnderecoDAO toDAO() {
        return EnderecoDAO
                .builder()
                .endereco(endereco)
                .numero(numero)
                .cidade(cidade)
                .estado(estado)
                .pais(pais)
                .build();
    }
    public EnderecoDTO(EnderecoDAO e) {
		this.numero = e.getNumero();
		this.endereco = e.getEndereco();
		this.cidade = e.getCidade();
		this.estado = e.getEstado();
		this.pais = e.getPais();
	}

}
