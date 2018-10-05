package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
 
public class ChatServer {
    
	private static List<PrintWriter> writers = new ArrayList<>();
    
 	public static void main(String[] args) throws IOException {
 		
 		ServerSocket serverSocket = null;
 		Socket clientSocket = null;
 		
 		try {
			serverSocket = new ServerSocket(10001);
		
			while(true) {
				clientSocket = serverSocket.accept();
				    
				new Thread(new ClientThread(clientSocket)).start();
			}

 		} catch (Throwable t) {
			System.out.println(t.getMessage());
		} finally {
			if (serverSocket != null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
			System.out.println("Server closed");
		}
 	}

	public static class ClientThread extends Thread {
	
		private Socket clientSocket;
		
		public ClientThread(Socket clientSocket) {
			this.clientSocket = clientSocket;  
	
		}
	
		public void run() {
			try {
				System.out.println("client connected from " + clientSocket.getInetAddress());
			    
				PrintWriter out =
			        new PrintWriter(clientSocket.getOutputStream(), true);
			    
				BufferedReader in = new BufferedReader(
			        new InputStreamReader(clientSocket.getInputStream()));
			    
				writers.add(out);

				String inputLine;
			    
			    while ((inputLine = in.readLine()) != null) {
			    	
			    	for(PrintWriter writer: writers) {
	    				writer.println(inputLine);
	    			}
			    	
			    	System.out.println(inputLine);
			        
			    	if (inputLine.equals("exit"))
			            break;
			    }
			} catch (Throwable t) {
				System.out.println(t.getMessage());
			}
		}
	}
}