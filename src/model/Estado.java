package model;

import util.Completable;
import util.Fetcher;

public class Estado implements Completable {

	public String codigo = "empty";
	public String nome = "empty";
	public Regiao regiao = null;
	
	public Estado() {
	}

	public Estado(String codigo, String nome, String regiao) {
		setCodigo_do_Estado(codigo);
		setNome(nome);
		setCodigo_da_Regiao(regiao);
	}
	
	public void fill() {
		regiao = Fetcher.getRegiao(regiao.getCodigo());
	}
	
	public void setCodigo_da_Regiao(String CodRegiao){
		if(regiao == null) regiao.setCodigo(CodRegiao);
		regiao.setCodigo(CodRegiao); 
	}
	
	public String getCodigo_da_Regiao(){
		return Integer.toString(regiao.getCodigo());
	}

	public void setCodigo_do_Estado ( String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo_do_Estado() {
		return codigo;
	}
	
	public int pegaCodigo(){
		return Integer.parseInt(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void poeRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
