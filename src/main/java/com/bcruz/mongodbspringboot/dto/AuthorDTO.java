package com.bcruz.mongodbspringboot.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.bcruz.mongodbspringboot.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nome;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
