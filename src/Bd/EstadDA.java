package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Estado;

public class EstadDA {
	
	private Connection conn;
	
	public EstadDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Estado est) throws SQLException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Estado(CodEst,CodReg,NomeEst) VALUES(?,?,?);");
		st.setInt(1, (Integer.parseInt( est.getCodigo_do_Estado() ) ) ) ;
		st.setInt(2, (Integer.parseInt( est.getCodigo_da_Regiao() ) ));
		st.setString(3, est.getNome());
		st.executeUpdate();
		st.close();
	}
	
	public void update(Estado est) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Estado SET NomeEst=?, CodReg=? WHERE CodEst=?;");
		st.setString(1, est.getNome());
		st.setInt(2, Integer.parseInt(est.getCodigo_da_Regiao()));
		st.setInt(3, (Integer.parseInt(est.getCodigo_do_Estado())));
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Estado WHERE CodEst=?;");
		st.setInt(1, Integer.parseInt(codigo));
		st.executeUpdate();
		st.close();
	}
	
	public Estado buscaPorCodigo(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Estado WHERE CodEst = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeEst");
			Estado est = new Estado(codigo,nome,"empty");
			rs.close();
			st.close();
			return est;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
	public Estado buscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Estado WHERE NomeEst = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String codigo = rs.getString("CodEst");
			Estado est = new Estado(codigo,nome,"empty");
			rs.close();
			st.close();
			return est;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
}
