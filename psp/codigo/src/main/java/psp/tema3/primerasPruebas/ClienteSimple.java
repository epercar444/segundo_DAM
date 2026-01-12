package psp.tema3.primerasPruebas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSimple {
	public static void main(String[] args) {
		String Host = "localhost"; //host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;//puerto remoto en el servidor que el cliente conoce         
		Socket cliente = null;
		try {
			cliente = new Socket(Host, Puerto);
			
			//informativo
			InetAddress i= cliente.getInetAddress ();
			System.out.println("Cliente : Puerto local: "+ cliente.getLocalPort());
			System.out.println("Cliente : Puerto Remoto: "+ cliente.getPort());  
			System.out.println("Cliente : Host Remoto: "+ i.getHostName().toString());  
			System.out.println("Cliente : IP Host Remoto: "+ i.getHostAddress().toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
