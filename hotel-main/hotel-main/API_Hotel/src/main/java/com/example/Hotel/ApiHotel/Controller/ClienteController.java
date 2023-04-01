package com.example.Hotel.ApiHotel.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.Hotel.ApiHotel.Models.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.repository.ClientRepository;
import com.example.Hotel.ApiHotel.service.ClienteService;

@RestController
public class ClienteController {
   
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> addClient (@RequestBody ClientDTO c){
        return clienteService.adicionarCliente(c);
    }

    @PutMapping ("/clients/{id}/atualizar")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long id,
                                                  @RequestBody ClientDTO c){

        return clienteService.atualizarCliente(id,c);
    }

    @GetMapping("/clientsall")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        return clienteService.obterClientes();
    }

    @GetMapping ("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id){
            return clienteService.obterCliente(id);
    }

    @DeleteMapping ("/clients/{id}/excluir")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id){
        return clienteService.deletarCliente(id);
    }
}
