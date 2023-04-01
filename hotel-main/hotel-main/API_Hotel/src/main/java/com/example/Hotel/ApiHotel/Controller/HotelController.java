package com.example.Hotel.ApiHotel.Controller;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import com.example.Hotel.ApiHotel.repository.ClientRepository;
import com.example.Hotel.ApiHotel.repository.HoteisRepository;
import com.example.Hotel.ApiHotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
 public class HotelController {

   @Autowired
   private HotelService hotelService;

   @PostMapping("/hoteis")
    public ResponseEntity<HoteisDTO> addHoteis(@RequestBody  HoteisDTO h) {
        return hotelService.adicionarHotel(h);
    }



   @PutMapping("/hoteis/{id}/atualize")
   public ResponseEntity<HoteisDTO> atualizarHoteis(@PathVariable("id") Long id,
                                                    @RequestBody HoteisDTO h) {
      return hotelService.atualizarHotel(id,h);
    }


    @GetMapping("/hoteis")
    public ResponseEntity<List<HoteisDTO>> getHoteis(){
       return hotelService.obterHoteis();
    }

    @GetMapping ("/hotel/{id}")
    public ResponseEntity<HoteisDTO> getClientById(@PathVariable("id") Long id){
        return hotelService.obterHotel(id);
   }

    @DeleteMapping("/hoteis/{id}/excluir")
    public ResponseEntity<HoteisDTO>deletarHotel(@PathVariable("id") Long id){
        return hotelService.deletarHotel(id);
    }
}

