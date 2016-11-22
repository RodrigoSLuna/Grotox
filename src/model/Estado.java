package model;

public class Estado {

	private String codigo = "empty";
	private String nome = "empty";

	public Estado() {
	}

	public Estado(String codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
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
