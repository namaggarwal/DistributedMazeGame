package client;


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
			ss.close();
		}catch(Exception e){
			
			System.out.println("Error in connecting to server. Please check if server is running.");
		}
		
		
	}
}
