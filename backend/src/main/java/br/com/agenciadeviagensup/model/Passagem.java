package br.com.agenciadeviagensup.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passagem")
public class Passagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_passagem;
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_destino")
	private Destino destino;

	public Passagem() {
		super();
	}

	public Passagem(Double preco, Cliente cliente, Destino destino) {
		super();
		this.preco = preco;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Long getId_passagem() {
		return id_passagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Destino getDestino() {
		return destino;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_passagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(id_passagem, other.id_passagem);
	}
	
	
	
}
