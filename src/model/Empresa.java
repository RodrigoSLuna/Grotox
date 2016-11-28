package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresa implements Iterable<Produto> {

	private String CNPJ, razaoSocial, nomeFantasia;
	private Image logo;
	private List<Produto> prods = new ArrayList<Produto>();

	public Empresa() {
		CNPJ = razaoSocial = nomeFantasia = "";
		logo = null;
	}

	public Empresa(String cnpj, String razaoSocial, String nomeFantasia, Image logo) {
		setCNPJ(cnpj);
		setRazao_Social(razaoSocial);
		setNome_Fantasia(nomeFantasia);
		setLogo(logo);
	}

	public void setCNPJ(String cnpj) {
		CNPJ = cnpj;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setRazao_Social(String rs) {
		razaoSocial = rs;
	}

	public String getRazao_Social() {
		return razaoSocial;
	}

	public void setNome_Fantasia(String nf) {
		nomeFantasia = nf;
	}

	public String getNome_Fantasia() {
		return nomeFantasia;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Image getLogo() {
		return logo;
	}

	@Override
	public Iterator<Produto> iterator() {
		return prods.iterator();
	}

	public boolean addProduto(Produto elem) {
		return prods.add(elem);
	}

	private boolean setProdutoOn(int idx, Produto elem) {
		if (idx < prods.size()) {
			prods.set(idx, elem);
			return true;
		}
		return false;
	}

	public Produto getProdutoOn(int index) {
		if (index < prods.size()) {
			return prods.get(index);
		}
		return null;
	}

}
