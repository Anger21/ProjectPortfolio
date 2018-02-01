package network;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Diese Klasse sendet die Bestelldaten an den Server, wo sie dann von einem anderem Programm
 * oder von Personen ausgelesen werden können können. 
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @throws IOException
 * @see Socket
 * @see FileReader
 * @see PrintWriter
 * @see Scanner
 */
public class Client {
	
	/**
	 * Stellt die Verbindung zum Server auf und sendet die Bestelldaten an den Server.
	 */
	public Client() {
		String host = "141.22.51.116";
		String host2 = "localhost";
		int port = 7777;
		String msg = "";
		
		try {
			Socket socket = new Socket (host2, port);
			
			System.out.println("Client verbindet sich mit dem Server");
			
			FileReader fileReader = new FileReader("Kunde.txt");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			//Lesen
			Scanner in = new Scanner(fileReader);
			while (in.hasNext()) {
				msg = in.nextLine();
				out.println(msg);
			}
			
			// Client schickt nachricht an Server
			
			
			out.flush();
			
			
			out.close();
			in.close();
			socket.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}