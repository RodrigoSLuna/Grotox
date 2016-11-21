package model;

import java.io.BufferedWriter;
import java.io.FileWriter;

import action.Obrigatorio;

public class Disciplina {
	
	@Obrigatorio(parametros = false)
	private String nome = "empty";
	
	@Obrigatorio(parametros = true)
	private String codigo = "empty";
	
	
	@Obrigatorio(parametros = true)
	private String ementa = "empty";
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public String toString(){
		return this.nome + "/" +this.codigo + "/" + this.ementa;
	}
	
}
