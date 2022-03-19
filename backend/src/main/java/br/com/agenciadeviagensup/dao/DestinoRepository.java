package br.com.agenciadeviagensup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenciadeviagensup.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
