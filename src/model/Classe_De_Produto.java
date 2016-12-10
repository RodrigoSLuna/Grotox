package model;

import util.Completable;

public class Classe_De_Produto implements Completable {

	private String codigo = "empty";
	private String nome = "empty";
	private String descricao = "empty";

	public Classe_De_Produto() {
		nome = descricao = "";
	}

	public Classe_De_Produto(String codigo, String nome) {
		descricao = "";
		this.codigo = codigo;
		this.nome = nome;
	}

	public Classe_De_Produto(String codigo, String nome, String desc) {
		setCodigo(codigo);
		setNome(nome);
		setDescricao(desc);
	}
	
	public void fill(){
		
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public int pegaCodigo(){
		return Integer.parseInt(codigo);
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
