package model1;

import java.io.BufferedWriter;
import java.io.FileWriter;

import action.Obrigatorio;

public class Professor {

	@Obrigatorio(parametros = false)
	private String nome = "empty";
	
	@Obrigatorio(parametros = true)
	private String email = "empty";
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
