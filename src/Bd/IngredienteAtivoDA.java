package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteAtivoDA {
	
	private Connection conn;
	
	public IngredienteAtivoDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(String codProd, String ingAtivo) throws SQLException {
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Regiao(CodProd,IngAtivo) VALUES(?,?);");
		st.setInt(1, Integer.parseInt(codProd)) ;
		st.setString(2, ingAtivo);
		st.executeUpdate();
		st.close();
	}
	
	public void update(String codProd, String ingAtivo, String newIngAtivo) throws SQLException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Regiao SET IngAtivo = ? WHERE CodProd=? AND IngAtivo=?;");
		st.setString(1, newIngAtivo);
		st.setInt(2, Integer.parseInt(codProd));
		st.setString(3, ingAtivo);
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codProd, String ingAtivo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Regiao WHERE CodProd=? AND IngAtivo=?;");
		st.setInt(1, Integer.parseInt(codProd));
		st.setString(2, ingAtivo);
		st.executeUpdate();
		st.close();
	}
	
	public List<String> buscaLista(String codProd) throws SQLException{
		List<String> vs = new ArrayList<String>();
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.IngredienteAtivo WHERE CodProd = ?;");
		st.setInt(1, Integer.parseInt(codProd));
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			String ingAtivo = rs.getString("IngAtivo");
			vs.add(ingAtivo);
		}
		rs.close();
		st.close();
		return vs;
	}
	
	/*public Regiao buscaPorCodigo(String codProd, String ingAtivo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Regiao WHERE CodReg = ? ;");
		st.setInt(1,Integer.parseInt(codigo));
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeReg");
			Regiao reg = new Regiao(Integer.parseInt(codigo),nome);
			return reg;
		}else{
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
			return reg;
		}else{
			return null;
		}
	}*/
	
}
