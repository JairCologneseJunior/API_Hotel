package com.example.Hotel.ApiHotel.service;

import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.repository.HoteisRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HoteisRepository hoteisRepository;

    public ResponseEntity<HoteisDTO> adicionarHotel(HoteisDTO h) {
        HoteisDAO hotelPersisted = hoteisRepository.save(h.toDAO());
        return new ResponseEntity<HoteisDTO>(hotelPersisted.toDTO(), HttpStatus.CREATED);
    }

    public ResponseEntity<HoteisDTO> atualizarHotel(Long id,  HoteisDTO h) {
       h.setId(id);
        System.out.println("");
       HoteisDAO hoteisatualize = hoteisRepository.save(h.toDAO());
       return new ResponseEntity<HoteisDTO>(hoteisatualize.toDTO(), HttpStatus.OK);
    }



    public ResponseEntity<List<HoteisDTO>> obterHoteis(){
       return ResponseEntity.ok().body(hoteisRepository.findAll()
                .stream()
                .map(hoteisDAO -> hoteisDAO.toDTO())
               .collect(Collectors.toList()));
    }


    public ResponseEntity<HoteisDTO> obterHotel(Long id){
        Optional<HoteisDAO> hoteis = hoteisRepository.findById(id);
        if (hoteis.isPresent()){     return new ResponseEntity<HoteisDTO>(hoteis.get().toDTO(), HttpStatus.OK);
      } else {
            return ResponseEntity.notFound().build();
       }
   }


    public ResponseEntity<HoteisDTO>deletarHotel(Long id){
        HoteisDAO hotel = new HoteisDAO();
        hotel.setId(id);
        hoteisRepository.delete(hotel);
        return ResponseEntity.noContent().build();

    }
}
