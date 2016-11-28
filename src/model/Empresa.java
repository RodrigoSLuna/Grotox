package model;

import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresa implements Iterable<Produto> {

	private String CNPJ, razaoSocial, nomeFantasia;
	private BufferedImage logo;
	private List<Produto> prods = new ArrayList<Produto>();

	public Empresa() {
		CNPJ = razaoSocial = nomeFantasia = "";
		logo = null;
	}

	public Empresa(String cnpj, String razaoSocial, String nomeFantasia, BufferedImage image) {
		setCNPJ(cnpj);
		setRazao_Social(razaoSocial);
		setNome_Fantasia(nomeFantasia);
		setLogo(image);
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

	public void setLogo(BufferedImage image) {
		this.logo = image;
	}

	public BufferedImage getLogo() {
		return logo;
	}

	@Override
	public Iterator<Produto> iterator() {
		return prods.iterator();
	}

	public boolean addProduto(Produto elem) {
		return prods.add(elem);
	}

	private boolean setProduto_On(int idx, Produto elem) {
		if (idx < prods.size()) {
			prods.set(idx, elem);
			return true;
		}
		return false;
	}

	public Produto getProduto_On(int index) {
		if (index < prods.size()) {
			return prods.get(index);
		}
		return null;
	}

}
