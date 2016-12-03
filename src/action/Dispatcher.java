package action;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    public Object cria( String nomeClasse ) throws Exception {
        Class<?> c = Class.forName( nomeClasse );
        Constructor<?> cs = c.getConstructor();

        return cs.newInstance();
    }

    public Method buscaMetodo( Class<?> classe, String nomeMetodo ) {
    	Method[] m = classe.getMethods();
    	for(Method o : m){
    		if(o.getName().equals(nomeMetodo))
    			return o;
    	}
        return null;
    }

    public Object instanciaForm( Method m ) throws Exception {
    	@SuppressWarnings("rawtypes")
		Class[] parametros = m.getParameterTypes();
    	for(Class<?> p: parametros){
    		if( p.getName() != null ){
    			return cria(p.getName());
    		}
    	}
        return null;
    }
    public String Format(String Nome){
    	return Nome.replace('_', ' ');
    }
    public Map<String, Method> buscaSetters( Class<?> classe ) {
    	Map<String,Method> MyMap = new HashMap<>(); 
    	Method[] m = classe.getMethods();	
    	for(Method met : m){
    		if(met.getName().toLowerCase().contains("set")){
    			MyMap.put( Format(  met.getName() ) , met);
    		}
    	}
        return MyMap;
    }
    public Map<String, Method> buscaGetters( Class<?> classe ) {
    	Map<String,Method> MyMap = new HashMap<>(); 
    	Method[] m = classe.getDeclaredMethods();	
    	for(Method met : m){
    		if(met.getName().toLowerCase().contains("get")){
    			MyMap.put( Format(  met.getName() ) , met);
    		}
    	}
        return MyMap;
    }
    											
    public String preencheForm( Object form, Map<String, String> parametros ) throws Exception {
    	Map<String, Method> setters = buscaSetters( form.getClass() );
    	
    	
    	for(String stringKey : setters.keySet()){
    		
      //  java.lang.reflect.Field field = form.getClass().getDeclaredField(stringKey.substring(3, stringKey.length()));
      //  field.setAccessible(true);
        	for(String stringDoor : parametros.keySet()){
        		
        		if(stringKey.toLowerCase().equals("set"+stringDoor.toLowerCase() )){
        			
        			if( (parametros.get(stringDoor)==""||parametros.get(stringDoor)==null) 
        					/*&& field.getAnnotation(Obrigatorio.class).parametros() == true*/ )
        				
        				// throw new Exception("O campo "+stringKey.substring(3, stringKey.length())+" � obrigatorio!");
        				return stringKey.substring(3, stringKey.length());

    				System.out.println("Preenche Form" + stringKey.replace(" ", "_" ));
        		
        			setters.get(stringKey).invoke( form,parametros.get(stringDoor));
        		}
        	}
        }
        return "ok";
    }


}
