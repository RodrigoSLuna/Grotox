package Bd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ClasseDeProduto;
import model.Empresa;
import model.Estado;
import model.Produto;
import model.Venda;

public class ConsultaDA {

	private Connection conn;
	
	public ConsultaDA() {
		conn = Conexao.getThis();
	}
	
	public List<Estado> one() throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT CodEst, NomeEst, FROM agro.Estado WHERE NomeEst LIKE 'A%';");
		ResultSet rs = st.executeQuery();
		List<Estado> ests = new ArrayList<Estado>();
		while(rs.next()){
			Estado est = new Estado();
			est.setCodigo_Estado(rs.getString("CodEst"));
			est.setNome(rs.getString("NomeEst"));
			ests.add(est);
		}
		rs.close();
		st.close();
		return ests;
	}
	
	public List<Estado> two() throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT CodEst, NomeEst FROM agro.Estado NATURAL JOIN agro.Regiao WHERE NomeReg = 'Norte';");
		ResultSet rs = st.executeQuery();
		List<Estado> ests = new ArrayList<Estado>();
		while(rs.next()){
			Estado est = new Estado();
			est.setCodigo_Estado(rs.getString("CodEst"));
			est.setNome(rs.getString("NomeEst"));
			ests.add(est);
		}
		rs.close();
		st.close();
		return ests;
	}
	
	public List<ClasseDeProduto> three() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT Nome, Descricao FROM agro.Produto P RIGHT OUTER JOIN agro.ClasseProd C ON P.CodClass = C.CodClass WHERE CodProd=NULL;");
		ResultSet rs = st.executeQuery();
		List<ClasseDeProduto> cdps = new ArrayList<ClasseDeProduto>();
		while(rs.next()){
			ClasseDeProduto cdp = new ClasseDeProduto();
			cdp.setNome(rs.getString("Nome"));
			cdp.setNome(rs.getString("Descricao"));
			cdps.add(cdp);
		}
		rs.close();
		st.close();
		return cdps;
	}
	
	public List<Venda> four() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT NomeProd, Quantidade, Mes, Ano, NomeEst FROM agro.Venda NATURAL JOIN agro.Estado NATURAL JOIN agro.Produto WHERE Ano BETWEEN 2012 AND 2016 ORDER BY NomeProd;");
		ResultSet rs = st.executeQuery();
		List<Venda> vs = new ArrayList<Venda>();
		while(rs.next()){
			Venda v = new Venda();
			v.setAno(rs.getInt("Ano"));
			Estado est = new Estado();
			est.setNome(rs.getString("NomeEst"));
			v.setEstado(est);
			v.setMes(rs.getInt("Mes"));
			Produto prod = new Produto();
			prod.setNome(rs.getString("NomeProd"));
			v.setProduto(prod);
			v.setQuantidade(rs.getInt("Quantidade"));
		}
		rs.close();
		st.close();
		return vs;
	}
	
	public List<Empresa> five() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT CNPJ, NomeFantasia, IngAtivo FROM agro.Empresa NATURAL JOIN agro.Produto NATURAL JOIN agro.IngredienteAtivo ORDER BY NomeFantasia;");
		ResultSet rs = st.executeQuery();
		List<Empresa> emps = new ArrayList<Empresa>();
		Map<String, Empresa> mep = new HashMap<String, Empresa>();
		while(rs.next()){
			String key = rs.getString("CNPJ");
			Empresa temp = mep.get(key);
			if(temp == null){
				temp = new Empresa();
				temp.setCNPJ(key);
				mep.put(key, temp);
				emps.add(temp);
			}
			temp.setNome_Fantasia(rs.getString("NomeFantasia"));
			Produto p = temp.getProduto_On(0);
			if(p == null){
				p = new Produto();
				temp.addProduto(p);
			}
			p.getIngredientesAtivos().add(rs.getString("IngAtivo"));
		}
		rs.close();
		st.close();
		return emps;
	}
	
	public List<Produto> six() throws SQLException {
		PreparedStatement st = conn.prepareStatement("(SELECT NomeProd FROM Produto NATURAL JOIN ClasseProd WHERE Nome LIKE '%Perigo%') UNION (SELECT NomeProd FROM Produto NATURAL JOIN ClasseProd WHERE IngAtivo = 'enxofre');");
		ResultSet rs = st.executeQuery();
		List<Produto> prods = new ArrayList<Produto>();
		while(rs.next()){
			Produto p = new Produto();
			p.setNome(rs.getString("NomeProd"));		
		}
		rs.close();
		st.close();
		return prods;
	} 
	
}
