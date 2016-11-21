package model2;

public class Estado {

	private int codigo;
	private String nome;
	
	public Estado(){
		codigo = -1; nome = "";
	}
	
	public Estado(int codigo, String nome){
		setCodigo(codigo);
		setNome(nome);
	}
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public String getNome(){
		return nome;
	}
}
