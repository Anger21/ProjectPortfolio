package network;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Diese Klasse nimmt die Bestelldaten auf und schreibt sie in die Konsole.
 * Hiermit kann man also die Bestelltdaten des Clients(Kunden) auslesen.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @throws IOException
 * @see ServerSocket
 * @see Socket
 * @see Scanner
 */
public class Server {

	public static void main(String[] args) {
		
		int port = 7777;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			
			System.out.println("Client ist verbunden");
			
			// empf‰ngt message vom client
			Scanner in = new Scanner(socket.getInputStream());
			while (in.hasNext()) {
				String msg = in.nextLine();
				
				System.out.println(msg);
			}
			
			// Scanner, printwriter und socket schlieﬂen
			in.close();
			socket.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}