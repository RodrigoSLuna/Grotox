package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Bd.EmpresaDA;

public class Produto implements Iterable<String> {

	private String codigo = "-1";
	private String nome = "empty";
	private String classe = "empty";
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
		setEmpresa_CNPJ(emp);
	}
	
	public void setEmpresa_CNPJ(String emp){
		EmpresaDA a = new EmpresaDA();
		try {
			empr = a.buscaCNPJ( emp );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		classe = clProduto;
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

}
