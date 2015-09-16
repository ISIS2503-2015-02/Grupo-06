import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Vcub 
{


	//-----------------------------------------------
	// Constantes
	//----------------------------------------------
	private final static String COMANDO_CAMBIAR_ESTADO="estado";
	
	private final static String COMANDO_CAMBIAR_POSICION="posicion";
	
	private final static String COMANDO_CAMBIAR_PRESTAMO="prestamo";
	
	private final static String HTTP="http://";
	
	private final static String LOCALHOST_RAILS="127.0.0.1:3000";
	
	private final static String URL_GET ="/vcubs.json";
	
	private final static String URL_PUT_ESTADO_PARTE_1="/vcubs/";
	
	private final static String URL_PUT_ESTADO_PARTE_2="/estado.json";
	
	private final static String URL_PUT_POSICION_PARTE_1="/vcubs/";
	
	private final static String URL_PUT_POSICION_PARTE_2="/posicion.json";
	
	private final static String URL_PUT_PRESTAR_PARTE_1="/vcubs/";
	
	private final static String URL_PUT_PRESTAR_PARTE_2="/prestada";
	

	//-----------------------------------------------
	// Atributos
	//----------------------------------------------
	
	private String id;
	
	
	//-----------------------------------------------
	// Métodos
	//----------------------------------------------
	
	/**
	 * Constructor de la clase.
	 */
	public Vcub(String idP)
	{
		id=idP;
	}
	
	/**
	 * Envía una petición GET al servidor. Imprime la respuesta.
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
		// El string buffer es una estructura de datos que hace más eficiente la concatenación de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
	}

	
	
	/**
	 * Envia una peticion PUT que cambia el estado del Vcub.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarEstado(String nuevoEstado) throws Exception
	{
		
		String url =  HTTP + LOCALHOST_RAILS + URL_PUT_ESTADO_PARTE_1 + id + URL_PUT_ESTADO_PARTE_2;	
		
		//Lo que va antes del '=' debe ser el nombre del parámetro que espera la aplicación
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
		// El string buffer es una estructura de datos que hace más eficiente la concatenación de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
		
	}
	
	
	/**
	 * Envia una peticion PUT que cambia la posicion del Vcub.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarPosicion(String nuevaPosicion) throws Exception
	{
		String url =  HTTP + LOCALHOST_RAILS + URL_PUT_POSICION_PARTE_1 + id + URL_PUT_POSICION_PARTE_2;
		
		//Lo que va antes del '=' debe ser el nombre del parámetro que espera la aplicación
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
		// El string buffer es una estructura de datos que hace más eficiente la concatenación de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		System.out.println(respuesta.toString());
		
	}
	
	/**
	 * Envia una peticion PUT que cambia el estado del prestamo del VCUB.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarEstadoPrestamo(String nuevoEstadoPrestamo) throws Exception
	{
		String url =  HTTP + LOCALHOST_RAILS + URL_PUT_PRESTAR_PARTE_1 + id + URL_PUT_PRESTAR_PARTE_2;
		
		//Lo que va antes del '=' debe ser el nombre del parámetro que espera la aplicación
		String parametros = "prestada="+nuevoEstadoPrestamo;
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
		// El string buffer es una estructura de datos que hace más eficiente la concatenación de Strings.
		StringBuffer respuesta = new StringBuffer();
		
		while ((input = in.readLine()) != null) 
		{
			respuesta.append(input);
		}
		
		in.close();
		
		//System.out.println(respuesta.toString());
		
	}


	//-----------------------------------------------
	// Método main
	//----------------------------------------------
	
	/**
	 * 
	 * @param args Parámetros del programam
	 */
	public static void main (String[] args)
	{
		
		//Deben haber exactamente tres parámetros: id, comando y nuevo valor.
		if(args.length != 3)
		{
			System.err.println("Uso: java Vcub <id> <comando> <nuevo Valor>");
			System.out.println("Uso: java Vcub <id> "+COMANDO_CAMBIAR_PRESTAMO+" <true/false>");
			System.out.println("comandos: " + COMANDO_CAMBIAR_ESTADO +"," + COMANDO_CAMBIAR_POSICION + ", "+COMANDO_CAMBIAR_PRESTAMO);
			System.exit(1);
		}
		
		//args[0] = id del vehículo
		//args[1] = comando. 
		//args[2] = el nuevo valor (Eje: EMERGENCIA, o 123123[es una posicion])
		Vcub instancia = new Vcub(args[0]);
		
		try 
		{
			if(args[1].equals(COMANDO_CAMBIAR_ESTADO)) 
				instancia.cambiarEstado(args[2]);
			
			if(args[1].equals(COMANDO_CAMBIAR_POSICION)) 
				instancia.cambiarPosicion(args[2]);
			
			if(args[1].equals(COMANDO_CAMBIAR_PRESTAMO)) 
				instancia.cambiarEstadoPrestamo(args[2]);
			
			//Envia una peticion GET
			//instancia.enviarGet();

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}	
}
