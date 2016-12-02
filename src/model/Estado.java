package model;

import action.Obrigatorio;

public class Estado {

	public String codigo = "empty";
	public String nome = "empty";
	public String regiao = "empty";

	
	
	public Estado() {
	}

	public Estado(String codigo, String nome, String regiao) {
		setCodigo_Estado(codigo);
		setNome(nome);
		setCodigo_Regiao(regiao);
	}
	
	public void setCodigo_Regiao(String Nomeregiao){
		this.regiao = Nomeregiao; 
		
	}
	
	public String getCodigo_Regiao(){
		return this.regiao;
	}

	public void setCodigo_Estado ( String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo_Estado() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
}
