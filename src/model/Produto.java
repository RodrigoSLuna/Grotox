package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Produto implements Iterable<String> {

	private int codigo;
	private String nome;
	private ClasseDeProduto classe = null;
	private List<String> ingAtivos = new ArrayList<String>();
	private Empresa empr;

	public Produto() {
		codigo = -1;
		nome = "";
	}

	public Produto(int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}
	
	public Produto(int codigo, String nome, ClasseDeProduto classe, Empresa emp){
		setCodigo(codigo);
		setNome(nome);
		setClasse(classe);
		setEmpresa(emp);
	}
	
	public void setEmpresa(Empresa empresa){
		empr = empresa;
	}
	
	public Empresa getEmpresa(){
		return empr;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setClasse(ClasseDeProduto clProduto){
		classe = clProduto;
	}
	
	public ClasseDeProduto getClasse(){
		return classe;
	}
	
	public List<String> getIngredientesAtivos() {
		return ingAtivos;
	}

	@Override
	public Iterator<String> iterator() {
		return ingAtivos.iterator();
	}

}
