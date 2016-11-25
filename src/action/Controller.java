package action;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.FormProduto;
import model1.Produto;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parametros = request.getParameterMap();
	
		String nomeDaClasse = "Form"+parametros.get("tipo")[0];
		
		
		String Metodo = parametros.get("acao")[0];
				if(!Metodo.equals("Consultar")){
			Map<String,String> SendParametros = new HashMap<String,String>();
			for(String a : parametros.keySet()){
				SendParametros.put(a, parametros.get(a)[0]);
				System.out.println(a + " " + SendParametros.get(a));
			}
			Dispatcher dis = new Dispatcher();
			try {
				Object o = dis.cria("model."+nomeDaClasse);
				Method m = dis.buscaMetodo(o.getClass(), Metodo);
				
				Object form = dis.instanciaForm( m );
				String a = dis.preencheForm(form, SendParametros);
				if(a.equals("ok")){
					response.sendRedirect((String) m.invoke(o,form));
				}else{
					 request.getRequestDispatcher("erro.jsp").forward(request, response);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else{
			response.setContentType("text/html");
		    request.setAttribute("acao", nomeDaClasse);;
		    request.getRequestDispatcher("consultar.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
