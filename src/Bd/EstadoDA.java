package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EstadoDA {
	
	public EstadoDA(){	
		
	}
	
	public void Consulta(int codigo) throws SQLException{
		Connection conn = Conexao.getThis();
		PreparedStatement st = conn.prepareStatement("Select * from Estado where codeEst = %d ");
		st.setInt(1, codigo);
		ResultSet rs = st.executeQuery();
		
		while( rs.next() ){
			rs.getInt( "codeEst" );
		}

	}
	
}
