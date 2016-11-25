package Bd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Estado;

public class ConsultaDA {

	public List<Estado> one() throws SQLException{
		Connection conn = Conexao.getThis();
		PreparedStatement st = conn.prepareStatement("SELECT CodEst, NomeEst, From agro.Estado WHERE NomeEst like 'A%';");
		ResultSet rs = st.executeQuery();
		List<Estado> ests = new ArrayList<Estado>();
		while(rs.next()){
			Estado est = new Estado();
			est.setCodigo(rs.getString("CodEst"));
			est.setNome(rs.getString("NomeEst"));
			ests.add(est);
		}
		return ests;
	}
	
}
