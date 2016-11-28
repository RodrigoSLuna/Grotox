package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Regiao;

public class RegiaoDA {
	
	private Connection conn;
	
	public RegiaoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Regiao reg) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Regiao(CodReg,NomeReg) VALUES(?,?);");
		st.setInt(1, reg.getCodigo() ) ;
		st.setString(2, reg.getNome());
		st.executeUpdate();
		st.close();
	}
	
	public void update(Regiao reg) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Regiao SET NomeReg=? WHERE CodReg=?;");
		st.setString(1, reg.getNome());
		st.setInt(2, reg.getCodigo());
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Regiao WHERE CodReg=?;");
		st.setInt(1, Integer.parseInt(codigo));
		st.executeUpdate();
		st.close();
	}
	
	public Regiao buscaPorCodigo(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Regiao WHERE CodReg = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeReg");
			Regiao reg = new Regiao(Integer.parseInt(codigo),nome);
			rs.close();
			st.close();
			return reg;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
	public Regiao buscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Regiao WHERE NomeReg = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			int codigo = rs.getInt("CodReg");
			Regiao reg = new Regiao(codigo,nome);
			rs.close();
			st.close();
			return reg;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
}
