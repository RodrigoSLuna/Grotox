package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Regiao implements Iterable<Estado> {

	private int codigo;
	private String nome;
	private List<Estado> ests = new ArrayList<Estado>();

	public Regiao() {
		codigo = -1;
		nome = "";
	}

	public Regiao(int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public boolean addEstado(Estado elem) {
		elem.setRegiao(this);
		return ests.add(elem);
	}

	public boolean setEstadoOn(int index, Estado elem) {
		if (index < ests.size()) {
			ests.set(index, elem);
			elem.setRegiao(this);
			return true;
		}
		return false;
	}

	public Estado getEstadoOn(int index) {
		if (index < ests.size()) {
			return ests.get(index);
		}
		return null;
	}

	@Override
	public Iterator<Estado> iterator() {
		return ests.iterator();
	}

}
