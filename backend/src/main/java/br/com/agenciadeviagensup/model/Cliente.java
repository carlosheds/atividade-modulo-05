package br.com.agenciadeviagensup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_cliente;
	private String nome;
	private int idade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Passagem> passagens = new ArrayList<Passagem>();
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		Id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public List<Passagem> getPassagens() {
		return passagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Id_cliente, other.Id_cliente);
	}
	
	

}
