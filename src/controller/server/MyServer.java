package controller.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyServer extends Thread implements Server {
	private int port;
	private String ip;
	private ServerSocket listenSocket;
	private Socket clientSocket;
	
	
	public MyServer(String ip,int port) {
		this.port=port;
		this.ip=ip;
		try {
			this.listenSocket= new ServerSocket(this.port);
			this.listenSocket.setSoTimeout(1000);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Server connecting on port " + this.port);
	     start();
		
	}
	  public void run()
	    {
	        try
	        {
	            while (true)
	            {
	                this.clientSocket = this.listenSocket.accept();  // wait for client
	                new Dialogue(this.clientSocket,this);   //  create new dialog
	            }
	        }
	        catch (IOException e)
	        {
	            System.out.println("Problem listening server-socket");
	            System.exit(1);
	        }

	        System.out.println("the server is out of service");
	    }
	
	
	

}
