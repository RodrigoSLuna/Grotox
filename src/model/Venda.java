package model;

import util.Completable;
import util.Fetcher;

public class Venda implements Completable {
	private int quantidade = -1, mes = -1, ano = -1;
	private Produto prod = null;
	private Estado est = null;

	public Venda() {
		quantidade = mes = ano = -1;
		prod = null;
		est = null;
	}

	public Venda(Produto prod, Estado est, int quantidade, int mes, int ano) {
		poeProduto(prod);
		poeEstado(est);
		poeQuantidade(quantidade);
		poeMes(mes);
		poeAno(ano);
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(String quantidade){
		poeQuantidade(Integer.parseInt(quantidade));
	}

	public void poeQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(String mes){
		poeMes(Integer.parseInt(mes));
	}
	
	public void poeMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(String ano){
		poeAno(Integer.parseInt(ano));
	}
	
	public void poeAno(int ano) {
		this.ano = ano;
	}

	public Produto getProduto() {
		return prod;
	}

	public void poeProduto(Produto prod) {
		this.prod = prod;
	}
	
	public void setCodigo_do_Produto(String codprod){
		if(prod == null) prod = new Produto();
		prod.setCodigo(codprod);
	}

	public Estado getEstado() {
		return est;
	}
	
	public void setCodigo_do_Estado(String codigo){
		if(est == null) est = new Estado();
		est.setCodigo_do_Estado(codigo);
	}

	public void poeEstado(Estado est) {
		this.est = est;
	}

	@Override
	public void fill() {
		est = Fetcher.getEstado(est.getCodigo_do_Estado());
		prod = Fetcher.getProduto(prod.getCodigo());
	}

}
