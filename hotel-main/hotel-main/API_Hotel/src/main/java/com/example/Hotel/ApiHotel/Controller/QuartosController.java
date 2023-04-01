package com.example.Hotel.ApiHotel.Controller;//package com.example.Hotel.ApiHotel.Controller;


import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.DTO.QuartosDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import com.example.Hotel.ApiHotel.DTO.HoteisDTO;
import com.example.Hotel.ApiHotel.Models.QuartosDAO;
import com.example.Hotel.ApiHotel.repository.QuartosRepository;
import com.example.Hotel.ApiHotel.service.QuartosService;
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
public class QuartosController {

    @Autowired
    private QuartosService quartosService;
    @PostMapping("/quartos")
   public ResponseEntity<QuartosDTO> addQuarto (@RequestBody @Valid QuartosDTO q){
        return quartosService.adicionarQuarto(q);
    }

    @GetMapping("/quartos")
    public ResponseEntity<List<QuartosDTO>> getQuartos(){
        return quartosService.obterQuartos();
    }

    @GetMapping ("/quartos/{id}")
    public ResponseEntity<QuartosDTO> getIdQuartos (@PathVariable("id") Long id){
       return quartosService.obterQuarto(id);
    }
    @DeleteMapping ("/quartos/{id}/deletar")
    public ResponseEntity<QuartosDTO> deletarQuarto(@PathVariable("id") Long id){
        return quartosService.deletarQuarto(id);
    }
    @PutMapping ("/quartos/{id}/atualizar")
   public ResponseEntity<QuartosDTO> atualizeQuarto(@PathVariable("id") Long id,
                                                    @RequestBody QuartosDTO q){
     return quartosService.atualizarQuarto(id,q);
 }
}
