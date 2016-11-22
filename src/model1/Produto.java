package model1;

import java.io.BufferedWriter;
import java.io.FileWriter;

import action.Obrigatorio;

public class Produto {
	
	@Obrigatorio(parametros = false)
	private String nome = "empty";
	
	@Obrigatorio(parametros = true)
	private String codigo = "empty";
	
	
	@Obrigatorio(parametros = true)
	private String iativo = "empty";
	
	
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
	public String getIAtivo() {
		return iativo;
	}
	public void setIativo(String iativo) {
		this.iativo = iativo;
	}
	public String toString(){
		return this.nome + "/" +this.codigo + "/" + this.iativo;
	}
	
}
	