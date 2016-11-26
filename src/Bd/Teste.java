package Bd;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class Teste {

	public static void main(String[] args) {
		Connection conn = Conexao.getThis();
		try {
			System.out.println("EU NAO QUERO BATATA!");
			PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Estado(CodEst,NomeEst,CodReg) Values (2,'Vila de Iape',1);");
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
