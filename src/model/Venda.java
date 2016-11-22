package model;

public class Venda {
	private int quantidade, mes, ano;
	private Produto prod;
	private Estado est;

	public Venda() {
		quantidade = mes = ano = -1;
		prod = null;
		est = null;
	}

	public Venda(Produto prod, Estado est, int quantidade, int mes, int ano) {
		setProduto(prod);
		setEstado(est);
		setQuantidade(quantidade);
		setMes(mes);
		setAno(ano);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Produto getProduto() {
		return prod;
	}

	public void setProduto(Produto prod) {
		this.prod = prod;
	}

	public Estado getEstado() {
		return est;
	}

	public void setEstado(Estado est) {
		this.est = est;
	}

}
