package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Estado;

public class EstadoDA {
	
	private Connection conn;
	
	public EstadoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Estado est) throws SQLException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Estado(CodEst,CodReg,NomeEst) VALUES(?,1,?);");
		st.setInt(1, (Integer.parseInt( est.getCodigo() ) ) ) ;
		st.setString(2, est.getNome());
		st.executeUpdate();
	}
	
	public void update(Estado est) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Estado SET NomeEst=?, CodReg=? WHERE CodEst=?;");
		st.setString(1, est.getNome());
		st.setInt(2,1);
		st.setInt(3, (Integer.parseInt(est.getCodigo())));
		st.executeUpdate();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Estado WHERE CodEst=?;");
		st.setInt(1, Integer.parseInt(codigo));
		st.executeUpdate();
	}
	
	public Estado BuscaPorCodigo(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Estado WHERE CodEst = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeEst");
			Estado est = new Estado(codigo,nome,"empty");
			return est;
		}else{
			return null;
		}
	}
	
	public Estado BuscaPorNome(String nome) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Estado WHERE NomeEst = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String codigo = rs.getString("CodEst");
			Estado est = new Estado(codigo,nome,"empty");
			return est;
		}else{
			return null;
		}
	}
	
}
