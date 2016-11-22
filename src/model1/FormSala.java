package model1;
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
public class FormSala {
			 public String Adicionar(Sala form){
				 try{
					 System.out.println("Adicionar " + form.getNome() + " " + form.getCapacidade());
						FileWriter fw = new FileWriter("sala.txt",true);
						
						BufferedWriter arq = new BufferedWriter(fw);
						arq.write(form.getNome()+ "," + form.getCapacidade() );
						arq.newLine();
						arq.close();
					}catch (Exception e){
						e.printStackTrace();
					}
				 return "sucesso.jsp";
			}
			 public String Editar(Sala form){
				 	System.out.println("Edicao");
				    String arquivo = "sala.txt";
			        String arquivoTmp = "salaTmp.txt";
			        boolean a = false;
				 try {
			            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
			            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

			            String linha;
			            
			            while ((linha = reader.readLine()) != null) {
			            	String[] l = linha.split(",");
			                if ( l[0].equals(form.getNome())) {
			                	a = true;
			                	writer.write(form.getNome()+","+form.getCapacidade() + "\n");
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
			 public String Excluir(Professor form){
				
				 System.out.println("Excluido!");
				 	String arquivo = "sala.txt";
			        String arquivoTmp = "salaTmp.txt";
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


