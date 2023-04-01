package com.example.Hotel.ApiHotel.service;

import com.example.Hotel.ApiHotel.DTO.QuartosDTO;
import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import com.example.Hotel.ApiHotel.repository.QuartosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuartosService {

    @Autowired
    private QuartosRepository quartosRepository;

   public ResponseEntity<QuartosDTO> adicionarQuarto(QuartosDTO q){
        QuartosDAO quartoPersisted = quartosRepository.save(q.toDAO());
        return new ResponseEntity<QuartosDTO>(quartoPersisted.toDTO(), HttpStatus.CREATED);
   }

    public ResponseEntity<List<QuartosDTO>> obterQuartos(){
       return ResponseEntity.ok().body(quartosRepository.findAll()
                .stream()
                .map(quartosDAO -> quartosDAO.toDTO())
                .collect(Collectors.toList()));
    }

    public ResponseEntity<QuartosDTO> obterQuarto (@PathVariable("id") Long id){
        Optional<QuartosDAO> quarto = quartosRepository.findById(id);
        if (quarto.isPresent()){
            return new ResponseEntity<QuartosDTO>(quarto.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<QuartosDTO> deletarQuarto(@PathVariable("id") Long id){
        QuartosDAO quarto = new QuartosDAO();
       quarto.setIdQuarto(id);
       quartosRepository.delete(quarto);
        return ResponseEntity.noContent().build();
    }


    public ResponseEntity<QuartosDTO> atualizarQuarto(@PathVariable("id") Long id, @RequestBody QuartosDTO q){
        q.setIdQuarto(id);
        System.out.println("");
        QuartosDAO quartosatualiza = quartosRepository.save(q.toDAO());
        return new ResponseEntity<QuartosDTO>(quartosatualiza.toDTO(), HttpStatus.OK);
    }

}
