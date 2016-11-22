package model1;

import java.io.BufferedWriter;
import java.io.FileWriter;

import action.Obrigatorio;

public class Sala {

	@Obrigatorio(parametros = false)
	private String nome = "empty";
	
	@Obrigatorio(parametros = true)
	private String capacidade = "empty";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String string) {
		this.capacidade = string;
	}
	

}
