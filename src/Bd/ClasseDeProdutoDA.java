package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ClasseDeProduto;

public class ClasseDeProdutoDA {
	
	private Connection conn;
	
	public ClasseDeProdutoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(ClasseDeProduto cdp) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.ClasseProd(Codigo,Nome,Descricao) VALUES(?,?,?);");
		st.setInt(1, cdp.getCodigo() ) ;
		st.setString(2, cdp.getNome());
		st.setString(3, cdp.getDescricao());
		st.executeUpdate();
	}
	
	public void update(ClasseDeProduto cdp) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.ClasseProd SET Nome=? Descricao=? WHERE Codigo=?;");
		st.setString(1, cdp.getNome());
		st.setString(2, cdp.getDescricao());
		st.setInt(3, cdp.getCodigo());
		st.executeUpdate();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.ClasseProd WHERE Codigo=?;");
		st.setInt(1, Integer.parseInt(codigo));
		st.executeUpdate();
	}
	
	public ClasseDeProduto buscaPorCodigo(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.ClasseProd WHERE Codigo = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("Nome");
			String desricao = rs.getString("Descricao");
			ClasseDeProduto cdp = new ClasseDeProduto(Integer.parseInt(codigo),nome,desricao);
			return cdp;
		}else{
			return null;
		}
	}
	
	public ClasseDeProduto buscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.ClasseProd WHERE Nome = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			int codigo = rs.getInt("Codigo");
			String desricao = rs.getString("Descricao");
			ClasseDeProduto cdp = new ClasseDeProduto(codigo,nome,desricao);
			return cdp;
		}else{
			return null;
		}
	}
	
}
