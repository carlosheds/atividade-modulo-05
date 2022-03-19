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
import br.com.agenciadeviagensup.dao.DestinoRepository;
import br.com.agenciadeviagensup.model.Destino;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/destino")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepo;
	
	@GetMapping
	public ResponseEntity<List<Destino>> findAll() {
		List<Destino> destinos = destinoRepo.findAll();
		
		return ResponseEntity.ok().body(destinos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Destino> findById(@PathVariable Long id) {
		Destino destino = destinoRepo.findById(id).get();
		
		return ResponseEntity.ok().body(destino);
	}
	
	// CREATE
    @PostMapping
    public Destino create(@RequestBody Destino destino) {
    	
        return destinoRepo.save(destino);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Destino> update(@PathVariable long id,@RequestBody Destino destinoDetails) {
    	Destino updateDestino = destinoRepo.findById(id).get();

    	updateDestino.setPais(destinoDetails.getPais());
    	updateDestino.setEstado(destinoDetails.getEstado());
    	updateDestino.setCidade(destinoDetails.getCidade());
    	
        destinoRepo.save(updateDestino);

        return ResponseEntity.ok(updateDestino);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Destino destino = destinoRepo.findById(id).get();

    	destinoRepo.delete(destino);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
