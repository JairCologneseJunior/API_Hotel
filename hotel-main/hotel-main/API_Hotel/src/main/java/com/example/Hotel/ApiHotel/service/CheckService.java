package com.example.Hotel.ApiHotel.service;

import com.example.Hotel.ApiHotel.DTO.CheckDTO;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.CheckDAO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.CheckRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CheckService {

    @Autowired
    private CheckRepository checkRepository;

    public ResponseEntity<CheckDTO>adicionarCheck(CheckDTO c){
        CheckDAO checkPersisted = checkRepository.save(c.toDAO());
        c.setAtive(true);
        checkPersisted.setAtive(true);
        return new ResponseEntity<CheckDTO>(checkPersisted.toDTO(), HttpStatus.CREATED);
    }

  /*  public ResponseEntity<CheckDTO> updateCheck(Long id, CheckDTO cks){
        CheckDAO checkoutUpdate = new CheckDAO();
        cks.setIdCheck(id);
        checkoutUpdate.setHorarioCheckIn(cks.getHorarioCheckIn());
        CheckDAO checkout = checkRepository.save(cks.toDAO());
        return new ResponseEntity<CheckDTO>(checkoutUpdate.toDTO(), HttpStatus.OK);

    }*/

    public ResponseEntity<CheckDTO> atualizarChecks(Long id, CheckDTO cks){
        cks.setIdCheck(id);
        CheckDAO checkAtualiza = checkRepository.save(cks.toDAO());
        return new ResponseEntity<CheckDTO>(checkAtualiza.toDTO(), HttpStatus.OK);
    }


    public ResponseEntity<List<CheckDTO>> obterChecks(){
        return ResponseEntity.ok().body(checkRepository.findAll()
                .stream()
                .map(checkDAO -> checkDAO.toDTO())
                .collect(Collectors.toList()));
    }

    public ResponseEntity<CheckDTO> deleteCheckById(@PathVariable("id") Long idCheck){
        CheckDAO check = checkRepository.findById(idCheck).get();
        check.setIdCheck(idCheck);
        check.fazerCheckOut();
        CheckDAO checkUpdate = checkRepository.save(check);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CheckDTO>obterCheck( Long id){
        Optional<CheckDAO> check = checkRepository.findById(id);
        if (check.isPresent()){
            return new ResponseEntity<CheckDTO>(check.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
