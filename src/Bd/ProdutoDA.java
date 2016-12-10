package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Classe_De_Produto;
import model.Empresa;
import model.Produto;

public class ProdutoDA {
	
	private Connection conn;
	
	public ProdutoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Produto p) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Produto(CodProd,NomeProd,CNPJ,CodClass) VALUES(?,?,?,?);");
		System.out.println("ESTA PASSANDO POR AQUI <---");
		st.setInt(1,Integer.parseInt( p.getCodigo() ) ) ;
		st.setString(2, p.getNome());
		System.out.println("Passou aqui");
		System.out.println( p.getEmpresa().getCNPJ() );
		st.setString(3, p.getEmpresa().getCNPJ());
		st.setInt(4, Integer.parseInt( p.getClasse_De_Produto()   ) );
		st.executeUpdate();
		st.close();
	}
	
	public void update(Produto p) throws SQLException {	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Produto SET NomeProd=?, CNPJ=?, CodClass=? WHERE CodProd=?;");
		st.setString(1, p.getNome());
		st.setString(2, p.getEmpresa().getCNPJ());
		st.setInt(3, Integer.parseInt ( p.getClasse_De_Produto() ) );
		st.setInt(4,Integer.parseInt( p.getCodigo() )) ;
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
			p.setCodigo(codigo);
			p.setNome(rs.getString("NomeProd"));
			Classe_De_Produto cdp = new Classe_De_Produto();
			cdp.setCodigo(rs.getString("CodClass"));
			Empresa emp = new Empresa();
			emp.setCNPJ(rs.getString("CNPJ"));
			p.poeClasse_De_Produto(cdp);
			p.poeEmpresa(emp);
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
			p.setCodigo(  rs.getString("CodProd")  );
			p.setNome(nome);
			Classe_De_Produto cdp = new Classe_De_Produto();
			cdp.setCodigo(rs.getString("CodClass"));
			Empresa emp = new Empresa();
			emp.setCNPJ(rs.getString("CNPJ"));
			p.poeClasse_De_Produto(cdp);
			p.poeEmpresa(emp);
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
