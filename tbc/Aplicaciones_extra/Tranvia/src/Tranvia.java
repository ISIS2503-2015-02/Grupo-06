import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

 /**
  *  @author Grupo 6 Arquitectura y dise�o de software
  */

public class Tranvia 
{
	
	//-----------------------------------------------
	// Constantes
	//----------------------------------------------
	
	private final static String COMANDO_CAMBIAR_ESTADO="estado";
	
	private final static String COMANDO_CAMBIAR_POSICION="posicion";
	
	private final static String COMANDO_REPORTAR_EMERGENCIA="emergencia";
	
	private final static String HTTP="http://";
	
	private final static String LOCALHOST_RAILS="127.0.0.1:3000";
	
	private final static String URL_GET ="/tranvia.json";
	
	private final static String URL_PUT_ESTADO_PARTE_1="/tranvia/";
	
	private final static String URL_PUT_ESTADO_PARTE_2="/estado.json";
	
	private final static String URL_PUT_POSICION_PARTE_1="/tranvia/";
	
	private final static String URL_PUT_POSICION_PARTE_2="/posicion.json";
	
	private final static String URL_POST_EMERGENCIA_PARTE_1="/tranvia/";
	
	private final static String URL_POST_EMERGENCIA_PARTE_2="/emergencia";
	
	
	//-----------------------------------------------
	// Atributos
	//----------------------------------------------
	
	private String id;
	
	
	//-----------------------------------------------
	// M�todos
	//----------------------------------------------

	/**
	 * Constructor de la clase.
	 */
	public Tranvia(String idP)
	{
		id=idP;
	}

	/**
	 * Env�a una petici�n GET al servidor. Imprime la respuesta.
	 * @throws Exception 
	 */
	private void enviarGet() throws Exception
	{	
		
		String url =  HTTP+LOCALHOST_RAILS+URL_GET;
		URL query= new URL(url);
		HttpURLConnection conexion =  (HttpURLConnection) query.openConnection();
		
		conexion.setRequestMethod("GET");
		
		int codigoRespuesta = conexion.getResponseCode();
		System.out.println("\n Enviando peticion 'GET' al URL : " + url);
		System.out.println("Codigo Respuesta: " + codigoRespuesta);
		
		// La respuesta se lee por medio de un buffered reader
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String input="";
		// El string buffer es una estructura de datos que hace m�s eficiente la concatenaci�n de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
	}
	
	/**
	 * Envia una peticion PUT que cambia el estado del tranvia.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarEstado(String nuevoEstado) throws Exception
	{
		
		String url =  HTTP + LOCALHOST_RAILS + URL_PUT_ESTADO_PARTE_1 + id + URL_PUT_ESTADO_PARTE_2;	
		
		//Lo que va antes del '=' debe ser el nombre del par�metro que espera la aplicaci�n
		String parametros = "estado="+nuevoEstado;
		byte[] postData   = parametros.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		
		URL query= new URL(url);
		HttpURLConnection conexion =  (HttpURLConnection) query.openConnection();
		conexion.setDoOutput(true);
		conexion.setInstanceFollowRedirects( false );
		conexion.setRequestMethod("PUT");
		conexion.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
		conexion.setRequestProperty( "charset", "utf-8");
		conexion.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		
		try( DataOutputStream wr = new DataOutputStream( conexion.getOutputStream())) 
		{
			wr.write( postData );
		}
		
		int codigoRespuesta = conexion.getResponseCode();
		System.out.println("\n Enviando peticion 'PUT' al URL : " + url);
		System.out.println("Codigo Respuesta: " + codigoRespuesta);
		
		// La respuesta se lee por medio de un buffered reader
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String input="";
		// El string buffer es una estructura de datos que hace m�s eficiente la concatenaci�n de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
		
	}
	
	/**
	 * Envia una peticion PUT que cambia la posicion del Tranvia.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarPosicion(String nuevaPosicion) throws Exception
	{
		String url =  HTTP + LOCALHOST_RAILS + URL_PUT_POSICION_PARTE_1 + id + URL_PUT_POSICION_PARTE_2;
		
		//Lo que va antes del '=' debe ser el nombre del par�metro que espera la aplicaci�n
		String parametros = "posicion="+nuevaPosicion;
		byte[] postData   = parametros.getBytes( StandardCharsets.UTF_8 );
		int postDataLength = postData.length;
		
		URL query= new URL(url);
		HttpURLConnection conexion =  (HttpURLConnection) query.openConnection();
		conexion.setDoOutput(true);
		conexion.setInstanceFollowRedirects( false );
		conexion.setRequestMethod("PUT");
		conexion.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
		conexion.setRequestProperty( "charset", "utf-8");
		conexion.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		
		try( DataOutputStream wr = new DataOutputStream( conexion.getOutputStream())) 
		{
			wr.write( postData );
		}
		
		int codigoRespuesta = conexion.getResponseCode();
		System.out.println("\n Enviando peticion 'PUT' al URL : " + url);
		System.out.println("Codigo Respuesta: " + codigoRespuesta);
		
		// La respuesta se lee por medio de un buffered reader
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String input="";
		// El string buffer es una estructura de datos que hace m�s eficiente la concatenaci�n de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
		
	}
	
	
	/**
	 * Envia una peticion POST que crea una nueva emergencia para el Tranvia.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void reportarEmergencia() throws Exception
	{
		String url =  HTTP + LOCALHOST_RAILS + URL_POST_EMERGENCIA_PARTE_1 + id + URL_POST_EMERGENCIA_PARTE_2;
		
		//No se necesitan par�metros
		String parametros = "";
		byte[] postData   = parametros.getBytes( StandardCharsets.UTF_8 );
		int postDataLength = postData.length;
		
		URL query= new URL(url);
		HttpURLConnection conexion =  (HttpURLConnection) query.openConnection();
		conexion.setDoOutput(true);
		conexion.setInstanceFollowRedirects( true ); // Porque si todo sale bien la petici�n debe ser redireccionada
		conexion.setRequestMethod("POST");
		conexion.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
		conexion.setRequestProperty( "charset", "utf-8");
		conexion.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		
		try( DataOutputStream wr = new DataOutputStream( conexion.getOutputStream())) 
		{
			wr.write( postData );
		}
		
		int codigoRespuesta = conexion.getResponseCode();
		System.out.println("\n Enviando peticion 'POST' al URL : " + url);
		System.out.println("Codigo Respuesta: " + codigoRespuesta);
		
		// La respuesta se lee por medio de un buffered reader
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String input="";
		// El string buffer es una estructura de datos que hace m�s eficiente la concatenaci�n de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		String resp = respuesta.toString();
		System.out.println(resp);
	
	}
	
	
	//-----------------------------------------------
	// M�todo main
	//----------------------------------------------
	
	/**
	 * 
	 * @param args Par�metros del programam
	 */
	public static void main (String[] args)
	{
		
		//Deben haber exactamente tres par�metros: id, comando y nuevo valor.
		if(args.length != 3 && args.length != 2)
		{
			System.err.println("Uso: java Tranvia <id> <comando> <nuevo Valor>");
			System.err.println("o java Tranvia <id> "+COMANDO_REPORTAR_EMERGENCIA);
			System.out.println("comandos: " + COMANDO_CAMBIAR_ESTADO +"," + COMANDO_CAMBIAR_POSICION +", "+ COMANDO_REPORTAR_EMERGENCIA);
			System.exit(1);
		}
		
		//args[0] = id del veh�culo
		//args[1] = comando. 
		//args[2] = el nuevo valor (Eje: EMERGENCIA, o 123123[es una posicion])
		Tranvia instancia = new Tranvia(args[0]);
		
		try 
		{
			if(args[1].equals(COMANDO_CAMBIAR_ESTADO)) 
				instancia.cambiarEstado(args[2]);
			
			if(args[1].equals(COMANDO_CAMBIAR_POSICION)) 
				instancia.cambiarPosicion(args[2]);
			
			if(args[1].equals(COMANDO_REPORTAR_EMERGENCIA)) 
				instancia.reportarEmergencia();
			
			
			//Envia una peticion GET
			//instancia.enviarGet();

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
}


