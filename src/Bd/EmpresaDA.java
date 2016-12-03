package Bd;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import model.Empresa;

public class EmpresaDA {
	
	private Connection conn;
	
	public EmpresaDA(){
		conn = Conexao.getThis();
	}
	
	public void insert(Empresa emp) throws SQLException, IOException{
		PreparedStatement st = conn.prepareStatement("INSERT INTO agro.Empresa(CNPJ,RazaoSocial,NomeFantasia,Logo) VALUES(?,?,?,?);");
		st.setString(1,emp.getCNPJ()) ;
		st.setString(2, emp.getRazao_Social());
		st.setString(3, emp.getNome_Fantasia());
		ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
		ImageIO.write(emp.getLogo(), "jpg", bytesImg);
		bytesImg.flush();
		byte[] byteArray = bytesImg.toByteArray();
		bytesImg.close();
		st.setBytes(4, byteArray);
		st.executeUpdate();
		st.close();
	}
	
	public void update(Empresa emp) throws SQLException, IOException{	
		PreparedStatement st = conn.prepareStatement("UPDATE agro.Empresa SET NomeFantasia=?, RazaoSocial=?, Logo=? WHERE CNPJ=?;");
		st.setString(1, emp.getRazao_Social());
		st.setString(2, emp.getNome_Fantasia());
		ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
		ImageIO.write(emp.getLogo(), "jpg", bytesImg);
		bytesImg.flush();
		byte[] byteArray = bytesImg.toByteArray();
		bytesImg.close();
		st.setBytes(3, byteArray);
		st.setString(4,emp.getCNPJ()) ;
		st.executeUpdate();
		st.close();
	}
	
	public void delete(String codigo) throws SQLException{
		PreparedStatement st = conn.prepareStatement("DELETE FROM agro.Empresa WHERE CNPJ=?;");
		st.setString(1,codigo);
		st.executeUpdate();
		st.close();
	}
	
	public Empresa buscaCNPJ(String codigo) throws SQLException, IOException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Empresa WHERE CNPJ = ? ;");
		st.setString(1,codigo);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String nome = rs.getString("NomeFantasia");
			String razao = rs.getString("RazaoSocial");
			Blob b = rs.getBlob("Logo");
			InputStream is = b.getBinaryStream();
			BufferedImage image = ImageIO.read(is);
			Empresa emp = new Empresa(codigo, razao, nome, image);
			rs.close();
			st.close();
			return emp;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
	public Empresa buscaPorNome(String nome) throws SQLException, IOException{
		PreparedStatement st = conn.prepareStatement("SELECT * FROM agro.Empresa WHERE NomeFantasia = ? ;");
		st.setString(1,nome) ;
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			String codigo = rs.getString("CNPJ");
			String razao = rs.getString("RazaoSocial");
			Blob b = rs.getBlob("Logo");
			InputStream is = b.getBinaryStream();
			BufferedImage image = ImageIO.read(is);
			Empresa emp = new Empresa(codigo, razao, nome, image);
			rs.close();
			st.close();
			return emp;
		}else{
			rs.close();
			st.close();
			return null;
		}
	}
	
}
