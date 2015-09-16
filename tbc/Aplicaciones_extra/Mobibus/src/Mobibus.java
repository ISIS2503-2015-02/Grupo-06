import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * http://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily
 * @author Grupo 6 Arquitectura y diseño de software
 *
 */

public class Mobibus 
{

	//-----------------------------------------------
	// Constantes
	//----------------------------------------------
	
	private final static String URL_GET_LOCAL="http://127.0.0.1:3000/mobibuses.json";
	
	private final static String URL_PUT_ESTADO_LOCAL="http://127.0.0.1:3000/mobibuses/1/estado.json";
	
	private final static String URL_PUT_POSICION_LOCAL="http://127.0.0.1:3000/mobibuses/2/posicion.json";
	
	private final static String ESTADO_EMERGENCIA ="EMERGENCIA";
	
	private final static int POSICION =2424;
	//-----------------------------------------------
	// Atributos
	//----------------------------------------------
	
	//-----------------------------------------------
	// Métodos
	//----------------------------------------------
	
	/**
	 * Constructor de la clase.
	 */
	public Mobibus()
	{
		
	}
	
	/**
	 * Envía una petición GET al servidor. Imprime la respuesta.
	 * @throws Exception 
	 */
	private void enviarGet() throws Exception
	{
		
		String url =  URL_GET_LOCAL;
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

	
	
	/* HTTP GET request
		private void sendGet() throws Exception 
		{

			String url = "http://www.google.com/search?q=mkyong";
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}*/
	
	/**
	 * Envia una peticion PUT que cambia el estado del mobibus.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarEstado(String nuevoEstado) throws Exception
	{
		
		String url =  URL_PUT_ESTADO_LOCAL;	
		String parametros = "estado="+ESTADO_EMERGENCIA;
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
	 * Envia una peticion PUT que cambia la posicion del mobibus.
	 * @param nuevoEstado El nuevo estado
	 * @throws Exception 
	 */
	private void cambiarPosicion(String nuevaPosicion) throws Exception
	{
		String url =  URL_PUT_POSICION_LOCAL;	
		String parametros = "posicion="+POSICION;
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


	//-----------------------------------------------
	// Método main
	//----------------------------------------------
	
	/**
	 * 
	 * @param args Parámetros del programam
	 */
	public static void main (String[] args)
	{
		
		Mobibus instancia = new Mobibus();
		
		try 
		{
			//Envia una peticion GET
			//instancia.enviarGet();
			
			//Envia una peticion de cambio de estado  a EMERGENCIA.
			//instancia.cambiarEstado(ESTADO_EMERGENCIA);
			
			//Envia una peticion de cambio de posicion
			instancia.cambiarPosicion(""+POSICION);
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
}
