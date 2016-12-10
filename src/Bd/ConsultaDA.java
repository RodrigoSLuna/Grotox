package Bd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Classe_De_Produto;
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
		PreparedStatement st = conn.prepareStatement("SELECT CodEst, NomeEst FROM agro.Estado WHERE NomeEst LIKE 'A%';");
		ResultSet rs = st.executeQuery();
		List<Estado> ests = new ArrayList<Estado>();
		while(rs.next()){
			Estado est = new Estado();
			est.setCodigo_do_Estado(rs.getString("CodEst"));
			est.setNome(rs.getString("NomeEst"));
			ests.add(est);
		}
		rs.close();
		st.close();
		//if(ests.size() == 0) return null;
		return ests;
	}
	
	public List<Estado> two() throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT CodEst, NomeEst FROM agro.Estado NATURAL JOIN agro.Regiao WHERE NomeReg = 'Norte';");
		ResultSet rs = st.executeQuery();
		List<Estado> ests = new ArrayList<Estado>();
		while(rs.next()){
			Estado est = new Estado();
			est.setCodigo_do_Estado(rs.getString("CodEst"));
			est.setNome(rs.getString("NomeEst"));
			ests.add(est);
		}
		rs.close();
		st.close();
		//if(ests.size() == 0) return null;
		return ests;
	}
	
	public List<Classe_De_Produto> three() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT Nome, Descricao FROM agro.Produto P RIGHT OUTER JOIN agro.ClasseProd C ON P.CodClass = C.CodClass;");
		ResultSet rs = st.executeQuery();
		List<Classe_De_Produto> cdps = new ArrayList<Classe_De_Produto>();
		while(rs.next()){
			Classe_De_Produto cdp = new Classe_De_Produto();
			cdp.setNome(rs.getString("Nome"));
			cdp.setDescricao(rs.getString("Descricao"));
			cdps.add(cdp);
		}

		rs.close();
		st.close();
		//if(cdps.size() == 0) return null;
		return cdps;
	}
	
	public List<Venda> four() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT NomeProd, Quantidade, Mes, Ano NomeEst FROM agro.Venda NATURAL JOIN agro.Estado NATURAL JOIN agro.Produto WHERE Ano BETWEEN 2012 AND 2016 ORDER BY NomeProd;");
		ResultSet rs = st.executeQuery();
		List<Venda> vs = new ArrayList<Venda>();
		while(rs.next()){
			Venda v = new Venda();
			v.poeAno(rs.getInt("Ano"));
			Estado est = new Estado();
			est.setNome(rs.getString("NomeEst"));
			v.poeEstado(est);
			v.poeMes(rs.getInt("Mes"));
			Produto prod = new Produto();
			prod.setNome(rs.getString("NomeProd"));
			v.poeProduto(prod);
			v.poeQuantidade(rs.getInt("Quantidade"));
			vs.add(v);
		}
		rs.close();
		st.close();
		//if(vs.size() == 0) return null;
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
			Produto p = temp.pegaProduto_On(0);
			if(p == null){
				p = new Produto();
				temp.addProduto(p);
			}
			p.getIngredientesAtivos().add(rs.getString("IngAtivo"));
		}
		rs.close();
		st.close();
		//if(emps.size() == 0) return null;
		return emps;
	}
	
	public List<Produto> six() throws SQLException {
		PreparedStatement st = conn.prepareStatement("(SELECT NomeProd FROM Produto NATURAL JOIN ClasseProd WHERE Nome LIKE '%Perigo%') UNION (SELECT NomeProd FROM Produto NATURAL JOIN ClasseProd WHERE IngAtivo = 'enxofre');");
		ResultSet rs = st.executeQuery();
		List<Produto> prods = new ArrayList<Produto>();
		while(rs.next()){
			Produto p = new Produto();
			p.setNome(rs.getString("NomeProd"));
			prods.add(p);
		}
		rs.close();
		st.close();
		//if(prods.size() == 0) return null;
		return prods;
	}
	
	public List<Produto> seven() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT NomeProd, count(IngAtivo) as numIngAtivos From agro.Produto natural join agro.IngredienteAtivo Group by NomeProd Order by numIngAtivos");
		ResultSet rs = st.executeQuery();
		List<Produto> prods = new ArrayList<Produto>();
		while(rs.next()){
			Produto p = new Produto();
			p.setNome(rs.getString("NomeProd"));
			int n = rs.getInt("numIngAtivos");
			while(n > 0){
				p.getIngredientesAtivos().add("A");
				n--;
			}
			prods.add(p);
		}
		rs.close();
		st.close();
		//if(prods.size() == 0) return null;
		return prods;
	}
	
	public List<Venda> eight() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT NomeProd, avg(Quantidade) as quantMedia From agro.Produto natural join agro.Venda WHERE Ano = 2014 Group by NomeProd Order by quantMedia");
		ResultSet rs = st.executeQuery();
		List<Venda> vs = new ArrayList<Venda>();
		while(rs.next()){
			Venda v = new Venda();
			Produto p = new Produto();
			p.setNome(rs.getString("NomeProd"));
			v.poeQuantidade((int) rs.getFloat("quantMedia"));
		}
		rs.close();
		st.close();
		//if(vs.size() == 0) return null;
		return vs;
	}
	
	public List<Venda> nine() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT NomeEst, sum(Quantidade) as quantTotal From agro.Estado natural join agro.Venda Group by NomeEst Order by quantTotal");
		ResultSet rs = st.executeQuery();
		List<Venda> vs = new ArrayList<Venda>();
		while(rs.next()){
			Venda v = new Venda();
			Estado est = new Estado();
			est.setNome(rs.getString("NomeEst"));
			v.poeQuantidade((int) rs.getFloat("quantTotal"));
		}
		rs.close();
		st.close();
		//if(vs.size() == 0) return null;
		return vs;
	}
	
	public List<Produto> ten() throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT IngAtivo From agro.IngredienteAtivo natural join (	SELECT CodProd, max(quantTotal)	From agro.Produto natural join ( SELECT CodProd, sum(quantidade) as quantTotal From agro.Venda Group by CodProd) as S ) as Q Order by IngAtivo");
		ResultSet rs = st.executeQuery();
		List<Produto> prods = new ArrayList<Produto>();
		Produto prod = new Produto();
		prods.add(prod);
		while(rs.next()){
			String ing = rs.getString("IngAtivo");
			prod.getIngredientesAtivos().add(ing);
		}
		rs.close();
		st.close();
		//if(prod.getQuantidade_de_ingredientes_ativos() == 0) return null;
		return prods;
	}
	
}
