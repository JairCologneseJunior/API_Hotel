package com.example.Hotel.ApiHotel.Controller;


import com.example.Hotel.ApiHotel.DTO.CheckDTO;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.CheckDAO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.CheckRepository;
import com.example.Hotel.ApiHotel.service.CheckService;
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
@RequestMapping(value = "/checks")
public class CheckController {

    @Autowired
    private CheckService checkService;


   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<CheckDTO> addCheck (@RequestBody @Valid CheckDTO c){
       return checkService.adicionarCheck(c);
    }


    @PutMapping("/{id}/atualizar")
    public ResponseEntity<CheckDTO> updateCheck(@PathVariable ("id") Long id,@RequestBody CheckDTO ck){
       return checkService.atualizarChecks(id,ck);
    }


   @GetMapping
    public ResponseEntity<List<CheckDTO>> getAllCheckout(){
       return checkService.obterChecks();
    }


    @DeleteMapping("/{id}/excluir")
    public ResponseEntity<CheckDTO> deleteCheckById(@PathVariable ("id") Long id){
        return checkService.deleteCheckById(id);
    }


    @GetMapping("/{id}/buscar")
    public ResponseEntity<CheckDTO>IdCheck(@PathVariable Long id){
       return checkService.obterCheck(id);
    }
}
