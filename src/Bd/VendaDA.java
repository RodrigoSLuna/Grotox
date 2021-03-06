package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Venda;

public class VendaDA {
	
	private Connection conn;
	
	public VendaDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Venda v) throws SQLException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Venda(CodEst,CodProd,Mes,Ano,Quantidade) VALUES(?,?,?,?,?);");
		st.setInt(1, (Integer.parseInt( v.getEstado().getCodigo_do_Estado() ) ) ) ;
		st.setInt(2, v.getProduto().pegaCodigo());
		st.setInt(3, v.getMes());
		st.setInt(4, v.getAno());
		st.setInt(5, v.getQuantidade());
		st.executeUpdate();
		st.close();
	}
	
	public void update(Venda v) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Venda SET Quantidade=? WHERE CodEst=? AND CodProd=? AND Mes=? AND Ano=?;");
		st.setInt(1, v.getQuantidade());
		st.setInt(2, (Integer.parseInt( v.getEstado().getCodigo_do_Estado() ) ) ) ;
		st.setInt(3, v.getProduto().pegaCodigo());
		st.setInt(4, v.getMes());
		st.setInt(5, v.getAno());
		st.executeUpdate();
		st.close();
	}
	
	public void delete(Venda v) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Venda WHERE CodEst=? AND CodProd=? AND Mes=? AND Ano=?;");
		st.setInt(1, Integer.parseInt(v.getEstado().getCodigo_do_Estado()));
		st.setInt(2, v.getProduto().pegaCodigo());
		st.setInt(3, v.getMes());
		st.setInt(4, v.getAno());
		st.executeUpdate();
		st.close();
	}
	
}
