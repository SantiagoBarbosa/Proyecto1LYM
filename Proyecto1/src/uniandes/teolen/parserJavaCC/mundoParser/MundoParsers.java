package uniandes.teolen.parserJavaCC.mundoParser;

import java.util.*;

import uniandes.teolen.parserJavaCC.parserProyecto1.Simple;



public class MundoParsers {
	
	// Nombres de los Parsers
	private  ArrayList  <String> parsers  = new ArrayList <String> (); 
	
	// Parser que se est� usando
	private int currentParser;
	
	
	public  MundoParsers () {
  	
		// Agreguen al final de esta lista los nombres del nuevo parser
		
	   
	    parsers.add("Simple");
	    
	    currentParser =  0;

	}
	
	
	
	public Simple getSimple(){
		return new Simple(System.in);
	}
	
	
	
	public String getStringCurrentParser(){
		return parsers.get(currentParser);
	}
	
	public int getCurrentParser() {
		return currentParser;
	}
	
	public void setCurrentParser(int p) {
		currentParser = p;
	}
	
	public String getParser(int i) {
		return parsers.get(i);
	}
	
	public int sizeParsers() {
		return parsers.size();
	}
	
	public String  procesarCadena(String texto) {
		String resp = "";
		
	
		
		 if (parsers.get(currentParser).equals("Simple")){
			Simple nuevoParser = getSimple();
			nuevoParser.ReInit(new java.io.StringReader(texto));
			try{
				nuevoParser.simple();
				resp= new String ("OK     \n");
			}
			catch (Exception e){
				resp = new String ("Error de sintaxis "+ e.getMessage());
			}
			catch (Error e){
				resp = new String("Error Lexico: "+ e.getMessage());
			}
		}
		
		return "\n SISTEMA " + parsers.get(currentParser) + ": " + resp + "\n";
	}

}
