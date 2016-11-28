package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ClasseDeProduto;
import model.Empresa;
import model.Produto;

public class ProdutoDA {
	
	private Connection conn;
	
	public ProdutoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Produto p) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Produto(CodProd,NomeProd,CNPJ,CodClass) VALUES(?,?,?,?);");
		st.setInt(1,p.getCodigo()) ;
		st.setString(2, p.getNome());
		st.setString(3, p.getEmpresa().getCNPJ());
		st.setInt(4, p.getClasse().getCodigo());
		st.executeUpdate();
		st.close();
	}
	
	public void update(Produto p) throws SQLException {	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Produto SET NomeProd=?, CNPJ=?, CodClass=? WHERE CodProd=?;");
		st.setString(1, p.getNome());
		st.setString(2, p.getEmpresa().getCNPJ());
		st.setInt(3, p.getClasse().getCodigo());
		st.setInt(4,p.getCodigo()) ;
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Produto WHERE CodProd=?;");
		st.setInt(1,Integer.parseInt(codigo));
		st.executeUpdate();
		st.close();
	}
	
	public Produto buscaPorCodigo(String codigo) throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Produto WHERE CodProd = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Produto p = new Produto();
			p.setCodigo(Integer.parseInt(codigo));
			p.setNome(rs.getString("NomeProd"));
			ClasseDeProduto cdp = new ClasseDeProduto();
			cdp.setCodigo(rs.getInt("CodClass"));
			Empresa emp = new Empresa();
			emp.setCNPJ(rs.getString("CNPJ"));
			p.setClasse(cdp);
			p.setEmpresa(emp);
			rs.close();
			st.close();
			return p;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
	public Produto buscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Produto WHERE NomeProd = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Produto p = new Produto();
			p.setCodigo(rs.getInt("CodProd"));
			p.setNome(nome);
			ClasseDeProduto cdp = new ClasseDeProduto();
			cdp.setCodigo(rs.getInt("CodClass"));
			Empresa emp = new Empresa();
			emp.setCNPJ(rs.getString("CNPJ"));
			p.setClasse(cdp);
			p.setEmpresa(emp);
			rs.close();
			st.close();
			return p;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
}
