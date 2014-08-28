package client;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MazeClient {

	
	public static void main(String[] args) {
		
		if(args.length != 2){
			
			System.err.println("Usage: java MazeClient <hostname> <port>");
			System.exit(1);
		}
		
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		
		try{
			
			System.out.println("Connecting to server....");
			Socket ss = new Socket(host,port);
			System.out.println("Connected to server");
			
			//To write to server socket
			PrintWriter out = new PrintWriter(ss.getOutputStream(),true);
			
			//To get input from server socket
			BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			
			//To get input from user keyboard
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String fromServer;
			
			String fromClient;
									
			while((fromServer = in.readLine()) != null){
							
				System.out.println("Server says : "+fromServer);
				
				if(fromServer.equals("Bye")){
					
					break;
				}
				
				fromClient = stdIn.readLine();
				
				if(fromClient != null){
					
					System.out.println("Client says " + fromClient);
                    out.println(fromClient);
				}
				
				
				
			}			
			
			ss.close();
			
		}catch(Exception e){
			
			System.out.println("Error in connecting to server. Please check if server is running.");
		}
		
		
	}
}
