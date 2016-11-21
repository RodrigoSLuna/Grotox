package model2;

public class ClasseDeProduto {

	private int codigo;
	private String nome, descricao;
	
	public ClasseDeProduto(){
		codigo = -1; nome = descricao = "";
	}
	
	public ClasseDeProduto(int codigo, String nome){
		descricao = "";
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public ClasseDeProduto(int codigo, String nome, String desc){
		setCodigo(codigo);
		setNome(nome);
		setDescricao(desc);
	}
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}
