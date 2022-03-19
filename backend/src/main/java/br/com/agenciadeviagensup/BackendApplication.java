package br.com.agenciadeviagensup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.agenciadeviagensup.dao.ClienteRepository;
import br.com.agenciadeviagensup.dao.DestinoRepository;
import br.com.agenciadeviagensup.dao.PassagemRepository;
import br.com.agenciadeviagensup.model.Cliente;
import br.com.agenciadeviagensup.model.Destino;
import br.com.agenciadeviagensup.model.Passagem;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private DestinoRepository destinoRepo;
	
	@Autowired
	private PassagemRepository passagemRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente("Carlos Silva",28);
		Cliente cliente2 = new Cliente("Marcela Duarte",28);
		
		Destino destino1 = new Destino("Brasil","RJ","RJ");
		Destino destino2 = new Destino("Brasil","SP","SP");
//		
		Passagem passagem1 = new Passagem(2000.0,cliente1,destino1);
		Passagem passagem2 = new Passagem(2000.0,cliente2,destino2);
//		
		cliente1.getPassagens().addAll(Arrays.asList(passagem1));
		cliente2.getPassagens().addAll(Arrays.asList(passagem2));
		
		clienteRepo.save(cliente1);
		clienteRepo.save(cliente2);
		
		destinoRepo.save(destino1);
		destinoRepo.save(destino2);
//		
		passagemRepo.save(passagem1);
		passagemRepo.save(passagem2);
		
		
	}

}
