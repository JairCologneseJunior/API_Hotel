package com.example.Hotel.ApiHotel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.ClientRepository;

@Service
public class ClienteService {

	@Autowired
	private ClientRepository clientRepository;

	public ResponseEntity<ClientDTO> adicionarCliente(ClientDTO cliente) {
		ClientDAO clientePersisted = clientRepository.save(cliente.toDAO());
		return new ResponseEntity<ClientDTO>(clientePersisted.toDTO(), HttpStatus.CREATED);
	}

	public ResponseEntity<ClientDTO> atualizarCliente(Long id, ClientDTO cliente ) {
		cliente.setId(id);
		ClientDAO clientUpdated = clientRepository.save(cliente.toDAO());
		return new ResponseEntity<ClientDTO>(clientUpdated.toDTO(), HttpStatus.OK);
	}

	public ResponseEntity<List<ClientDTO>> obterClientes() {
		return ResponseEntity.ok().body(
				clientRepository.findAll().stream()
						.map(clientDAO -> clientDAO.toDTO()).collect(Collectors.toList()));
	}

	public ResponseEntity<ClientDTO> obterCliente(@PathVariable Long id) {
		Optional<ClientDAO> client = clientRepository.findById(id);
		if (client.isPresent()) {
			return new ResponseEntity<ClientDTO>(client.get().toDTO(), HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	public ResponseEntity<ClientDTO> deletarCliente(@PathVariable Long id) {
		ClientDAO client = new ClientDAO();
		client.setId(id);
		clientRepository.delete(client);
		return ResponseEntity.noContent().build();
	}

}
