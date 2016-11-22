package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Produto implements Iterable<ClasseDeProduto> {

	private int codigo;
	private String nome;
	private List<ClasseDeProduto> classes = new ArrayList<ClasseDeProduto>();
	private List<String> ingAtivos = new ArrayList<String>();

	public Produto() {
		codigo = -1;
		nome = "";
	}

	public Produto(int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
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

	public ClasseDeProduto getClasseOn(int idx) {
		if (classes.size() > idx) {
			return classes.get(idx);
		}
		return null;
	}

	public boolean addClasse(ClasseDeProduto elem) {
		return classes.add(elem);
	}

	public boolean setClasseOn(int idx, ClasseDeProduto elem) {
		if (idx < classes.size()) {
			classes.set(idx, elem);
			return true;
		}
		return false;
	}

	public List<String> getIngredientesAtivos() {
		return ingAtivos;
	}

	@Override
	public Iterator<ClasseDeProduto> iterator() {
		return classes.iterator();
	}

}
