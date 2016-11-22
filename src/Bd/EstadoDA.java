package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Estado;

public class EstadoDA {
	
	public EstadoDA(){
		
	}
	
	public void insert(Estado est) throws SQLException{
		Connection conn = Conexao.getThis();
		PreparedStatement st = conn.prepareStatement("Insert into agro.Estado(CodEst,CodReg,NomeEst) values(?,1,?);");
		st.setInt(1, (Integer.parseInt( est.getCodigo() ) ) ) ;
		st.setString(2, est.getNome());
		st.executeUpdate();
	}
	
	public Estado Consulta(String codigo) throws SQLException{
		Connection conn = Conexao.getThis();
		PreparedStatement st = conn.prepareStatement("Select * from agro.Estado where CodEst = ? ;");
		st.setInt(1,Integer.parseInt(  codigo ) ) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeEst");
			Estado est = new Estado(  codigo  , nome);
			return est;
		}else{
			return null;
		}
	}
	
}
