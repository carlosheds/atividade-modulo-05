package br.com.agenciadeviagensup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenciadeviagensup.model.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long>{

}
