package model;

public class Estado {

	private String codigo = "empty";
	private String nome = "empty";
	private Regiao reg = null;

	public Estado() {
		
	}

	public Estado(String codigo, String nome, Regiao regiao) {
		setCodigo(codigo);
		setNome(nome);
		setRegiao(regiao);
	}
	
	public void setRegiao(Regiao regiao){
		reg = regiao;
	}
	
	public Regiao getRegiao(){
		return reg;
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
