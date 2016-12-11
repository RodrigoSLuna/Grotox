package util;

import java.io.IOException;
import java.sql.SQLException;

import Bd.ClasseDeProdutoDA;
import Bd.EmpresaDA;
import Bd.EstadDA;
import Bd.ProdutoDA;
import Bd.RegiaoDA;
import model.Classe_De_Produto;
import model.Empresa;
import model.Estado;
import model.Produto;
import model.Regiao;

public class Fetcher {
	
	public static Empresa getEmpresa(String CNPJ){
		Empresa emp = new Empresa();
		try{
			EmpresaDA da = new EmpresaDA();
			emp = da.buscaCNPJ(CNPJ);
		}catch(SQLException | IOException e){
			e.printStackTrace();
			emp.setNome_Fantasia(e.getMessage());
		}
		return emp;
	}

	public static Classe_De_Produto getClasseDeProduto(String codigo) {
		Classe_De_Produto cdp = new Classe_De_Produto();
		try{
			ClasseDeProdutoDA da = new ClasseDeProdutoDA();
			cdp = da.buscaPorCodigo(codigo);
		}catch (SQLException e){
			e.printStackTrace();
			cdp.setNome(e.getMessage());
		}
		return cdp;
	}

	public static Regiao getRegiao(int codigo) {
		Regiao reg = new Regiao();
		try{
			RegiaoDA da = new RegiaoDA();
			reg = da.buscaPorCodigo(Integer.toString(codigo));
		}catch (SQLException e){
			e.printStackTrace();
			reg.setNome(e.getMessage());
		}
		return reg;
	}

	public static Produto getProduto(String codigo) {
		Produto prod = new Produto();
		try{
			ProdutoDA da = new ProdutoDA();
			prod = da.buscaPorCodigo(codigo);
		}catch (SQLException e){
			e.printStackTrace();
			prod.setNome(e.getMessage());
		}
		return prod;
	}

	public static Estado getEstado(String codigo) {
		Estado est = new Estado();
		try{
			EstadDA da = new EstadDA();
			est = da.buscaPorCodigo(codigo);
		}catch (SQLException e){
			e.printStackTrace();
			est.setNome(e.getMessage());
		}
		return est;
	}
	
}
