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
import br.com.agenciadeviagensup.dao.DestinoRepository;
import br.com.agenciadeviagensup.dao.PassagemRepository;
import br.com.agenciadeviagensup.model.Cliente;
import br.com.agenciadeviagensup.model.Destino;
import br.com.agenciadeviagensup.model.Passagem;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/passagem")
public class PassagemController {
	
	@Autowired
	private PassagemRepository passagemRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private DestinoRepository destinoRepo;
	
	@GetMapping
	public ResponseEntity<List<Passagem>> findAll() {
		List<Passagem> passagens = passagemRepo.findAll();
		
		return ResponseEntity.ok().body(passagens);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Passagem> findById(@PathVariable Long id) {
		Passagem passagem = passagemRepo.findById(id).get();
		
		return ResponseEntity.ok().body(passagem);
	}
	
	// CREATE
    @PostMapping
    public Passagem createEmployee(@RequestBody Passagem passagem) {
    	
        return passagemRepo.save(passagem);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Passagem> update(@PathVariable Long id,@RequestBody Passagem passagemDetails ) {
    	Passagem updatePassagem = passagemRepo.findById(id).get();
    	Cliente cliente = clienteRepo.findById(passagemDetails.getCliente().getId_cliente()).get();
    	Destino destino = destinoRepo.findById(passagemDetails.getDestino().getId_destino()).get();

    	updatePassagem.setPreco(passagemDetails.getPreco());
    	updatePassagem.setCliente(cliente);
    	updatePassagem.setDestino(destino);

    	passagemRepo.save(updatePassagem);

        return ResponseEntity.ok(updatePassagem);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Passagem cliente = passagemRepo.findById(id).get();

    	passagemRepo.delete(cliente);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
