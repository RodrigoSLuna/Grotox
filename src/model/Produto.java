package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Completable;
import util.Fetcher;

public class Produto implements Iterable<String>, Completable {

	private String codigo = "-1";
	private String nome = "empty";
	private Classe_De_Produto classe = null;
	private List<String> ingAtivos = new ArrayList<String>();
	private Empresa empr = null;

	public Produto() {
		codigo = "-1";
		nome = "";
	}

	public Produto(String codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}
	
	public Produto(String codigo, String nome, String classe, String emp){
		setCodigo(codigo);
		setNome(nome);
		setClasse_De_Produto(classe);
		setCNPJ_da_Empresa(emp);
	}
	
	public void setCNPJ_da_Empresa(String emp){
		if(empr == null) empr = new Empresa();
		empr.setCNPJ(emp);
	}
	
	public void fill(){
		empr = Fetcher.getEmpresa(empr.getCNPJ());
		classe = Fetcher.getClasseDeProduto(classe.getCodigo());
	}
	
	public Empresa getEmpresa(){
		return empr;
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

	public void setClasse_De_Produto(String clProduto){
		if(classe == null) classe = new Classe_De_Produto();
		classe.setCodigo(clProduto);
	}
	
	public String getClasse_De_Produto(){
		Classe_De_Produto cdl = new Classe_De_Produto();
		return cdl.getCodigo();
	}
	
	public List<String> getIngredientesAtivos() {
		return ingAtivos;
	}

	@Override
	public Iterator<String> iterator() {
		return ingAtivos.iterator();
	}

	public void poeEmpresa(Empresa empresa) {
		empr = empresa;
	}

	public void poeClasse_De_Produto(Classe_De_Produto cdp) {
		this.classe = cdp;
	}

	public int pegaCodigo() {
		return Integer.parseInt(codigo);
	}
	
	public int getQuantidade_de_ingredientes_ativos(){
		return ingAtivos.size();
	}

}
