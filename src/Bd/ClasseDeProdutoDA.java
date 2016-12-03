package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Classe_De_Produto;

public class ClasseDeProdutoDA {
	
	private Connection conn;
	
	public ClasseDeProdutoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Classe_De_Produto cdp) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.ClasseProd(CodClass,Nome,Descricao) VALUES(?,?,?);");
		st.setInt(1,  Integer.parseInt ( cdp.getCodigo() )  ) ;
		st.setString(2, cdp.getNome());
		st.setString(3, cdp.getDescricao());
		st.executeUpdate();
		st.close();
	}
	
	public void update(Classe_De_Produto cdp) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.ClasseProd SET Nome=? Descricao=? WHERE Codigo=?;");
		st.setString(1, cdp.getNome());
		st.setString(2, cdp.getDescricao());
		st.setInt(3, Integer.parseInt ( cdp.getCodigo() ) );
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.ClasseProd WHERE Codigo=?;");
		st.setInt(1, Integer.parseInt(codigo));
		st.executeUpdate();
		st.close();
	}
	
	public Classe_De_Produto buscaPorCodigo(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.ClasseProd WHERE Codigo = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("Nome");
			String desricao = rs.getString("Descricao");
			Classe_De_Produto cdp = new Classe_De_Produto( codigo,nome,desricao);
			rs.close();
			st.close();
			return cdp;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
	public Classe_De_Produto buscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.ClasseProd WHERE Nome = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String codigo = rs.getString("Codigo");
			String desricao = rs.getString("Descricao");
			Classe_De_Produto cdp = new Classe_De_Produto(codigo,nome,desricao);
			rs.close();
			st.close();
			return cdp;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
}
