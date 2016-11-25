package model;

public class Estado {

	private String codigo = "empty";
	private String nome = "empty";
	private String regiao = "empty";

	public Estado() {
		
	}

	public Estado(String codigo, String nome, String regiao) {
		setCodigo(codigo);
		setNome(nome);
		setRegiao(regiao);
	}
	
	public void setRegiao(String Nomeregiao){

		this.regiao =   Nomeregiao  ; 
		
	}
	
	public String getRegiao(){
		return this.regiao;
	}

	public void setCodigo ( String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
}
