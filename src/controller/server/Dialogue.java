package controller.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Dialogue {
	private Socket client;
	private Server Server;
	private BufferedReader socketInput;
	private PrintWriter sokcketOutPut;
	private int numOfLines;
	
	public Dialogue(Socket client,Server server) {
		this.client=client;
		this.Server=server;
		try {
			this.socketInput= new BufferedReader(new InputStreamReader(client.getInputStream()));
			this.sokcketOutPut= new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

public void run(){
	
	
}

}
