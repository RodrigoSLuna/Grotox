package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Completable;

public class Empresa implements Iterable<Produto>, Completable {

	private String CNPJ = "empty", razaoSocial = "empty", nomeFantasia = "empty";
	private BufferedImage logo = null;
	private List<Produto> prods = new ArrayList<Produto>();

	public void fill(){
		for(Produto prod : prods){
			prod.poeEmpresa(this);
		}
	}
	
	public Empresa() {
		
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

	public boolean poeProduto_On(int idx, Produto elem) {
		if (idx < prods.size()) {
			prods.set(idx, elem);
			elem.setCNPJ_da_Empresa(CNPJ);
			return true;
		}
		return false;
	}

	public Produto pegaProduto_On(int index) {
		if (index < prods.size()) {
			return prods.get(index);
		}
		return null;
	}
	
	@Override
	public String toString() {
		return nomeFantasia + "("+razaoSocial+")";
	}

}
