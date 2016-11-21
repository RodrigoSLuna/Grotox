package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Dispatcher;

public class FormDisciplina  extends HttpServlet{

	 public String Adicionar(Disciplina form){
		 try{
			 System.out.println("Adicionar");
			
				FileWriter fw = new FileWriter("disciplina.txt",true);
				
				BufferedWriter arq = new BufferedWriter(fw);
				arq.write(form.getNome()+ "," + form.getCodigo() + "," + form.getEmenta() );
				arq.newLine();
				arq.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		 return "sucesso.jsp";
	}
	 public String Editar(Disciplina form){
		 	System.out.println("Edicao");
		    String arquivo = "disciplina.txt";
	        String arquivoTmp = "disciplinaTmp.txt";
	        boolean a = false;
		 try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
	            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            	

	            String linha;

	            while ((linha = reader.readLine()) != null) {
	        
	            	String[] l = linha.split(",");
	                if ( l[0].equals(form.getNome()) ) {
	                	a = true;
	                	System.out.println("Modificou!!: " + linha + "->" + form.toString() );
	                	writer.write(form.getNome()+","+form.getCodigo()+","+form.getEmenta()+ "\n");
	                	writer.newLine();
	                }
	                else{
	                	writer.write(linha);
	                	writer.newLine();
	                }
	            }

	            writer.close();
	            reader.close();

	            new File(arquivo).delete();
	            new File(arquivoTmp).renameTo(new File(arquivo));
	            
	        } catch (IOException e) {
	            System.out.println("Erro: " + e);
	        }
		 if(a)
			 return "sucesso.jsp";
		 
		 return "falho.jsp";
					 
		 
	 }
	 public String Excluir(Disciplina form){
	 
		 System.out.println("Excluido!");
		 	String arquivo = "disciplina.txt";
	        String arquivoTmp = "disciplinaTmp.txt";
	        boolean a = false;

	        try {
	           
	        	 BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		         BufferedReader reader = new BufferedReader(new FileReader(arquivo));
	            String linha;

	            while ((linha = reader.readLine()) != null) {
	            	String[] l = linha.split(",");
	                if (! l[0].equals(form.getNome())) {
	                	writer.write(linha);
	                	writer.newLine();
	                	a = true;
	                }
	            }
	            writer.close();
	            reader.close();
	        } catch (IOException e) {
		            System.out.println("Erro: " + e);
		        }

	          
	            new File(arquivo).delete();
	            new File(arquivoTmp).renameTo(new File(arquivo));
		 
	            if(!a)
	   			 return "sucesso.jsp";
	   		 
	   		 return "falho.jsp";
		 
	        }
	
	 }

