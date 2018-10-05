package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketsClient {
 	public static void main(String[] args) throws IOException {
		Socket socket = null;
		try {
			    socket = new Socket("localhost", 10001);
			    
			    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			    
			    BufferedReader in = new BufferedReader(
			            new InputStreamReader(socket.getInputStream()));
			    
			    BufferedReader stdIn = new BufferedReader(
			            new InputStreamReader(System.in));
			    String userInput;
			    
			    try {
	                while ((userInput = stdIn.readLine()) != null) {
	                    out.println(userInput);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
			    
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}
 }