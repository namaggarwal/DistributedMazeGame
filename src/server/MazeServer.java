package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MazeServer {
	
	
	private void start(int port){
		
		//Set this variable to false to stop the server
		boolean listening = true;
		
		try{
			
			System.out.println("Starting server on port "+port);
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Server Started");
			System.out.println("Running on -- ");
			System.out.println("Host : "+ ss.getInetAddress());
			System.out.println("Port : "+ port);
			
			while(listening){
				
				System.out.println("Waiting for client to connect...");
				Socket MazeClient  = ss.accept();
				System.out.println("Client connected.");
				System.out.println("Client host "+MazeClient.getInetAddress());
				System.out.println("Client port "+MazeClient.getPort());
				
				//To write to client socket
				PrintWriter out = new PrintWriter(MazeClient.getOutputStream(),true);
			
				//To read from client socket
				BufferedReader in = new BufferedReader(new InputStreamReader(MazeClient.getInputStream()));
							
				String clientInput;
			
				out.println("Connected");
				
				while((clientInput = in.readLine()) != null ){
					
					System.out.println("Client says : "+clientInput);
					out.println(clientInput);
					if(clientInput.equals("Bye")){
						break;
					}
					
					
				}
				
				// Close the socket connection
				ss.close();
				
			}
			
			
			
			
		}catch(IOException e){
			
			System.err.println("Could not listen on port " + port);
            System.exit(-1);
            
		}finally{
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		if(args.length != 1){
			System.err.println("Usage: java MazeServer <port number>");
			System.exit(1);
		}
		
		int port = Integer.parseInt(args[0]);
		
		MazeServer ms = new MazeServer();
		ms.start(port);
		
	}

}
