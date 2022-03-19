package br.com.agenciadeviagensup.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenciadeviagensup.dao.ClienteRepository;
import br.com.agenciadeviagensup.model.Cliente;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteRepo.findAll();
		
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteRepo.findById(id).get();
		
		return ResponseEntity.ok().body(cliente);
	}
	
	// CREATE
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
    	
        return clienteRepo.save(cliente);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable long id,@RequestBody Cliente clienteDetails) {
    	Cliente updateCliente = clienteRepo.findById(id).get();

    	updateCliente.setNome(clienteDetails.getNome());
    	updateCliente.setIdade(clienteDetails.getIdade());

        clienteRepo.save(updateCliente);

        return ResponseEntity.ok(updateCliente);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {

    	Cliente cliente = clienteRepo.findById(id).get();

    	clienteRepo.delete(cliente);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
