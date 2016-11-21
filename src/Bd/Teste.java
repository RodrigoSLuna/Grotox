package Bd;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class Teste {

	public static void main(String[] args) {
		Connection conn = Conexao.getThis();
		try {
			PreparedStatement st = conn.prepareStatement("INSERT INTO Batata (Codigo, Nome, NumPelos, EscalaMaturacao) Values (1000,'Joao',20,5);");
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
