package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class MazeServerThread extends Thread {
	
	
	Socket mc;
	
	public MazeServerThread(Socket mc){
		
		
		this.mc = mc;
	}
	
	public void run(){			
		
		try{
			
			//To write to client socket
			PrintWriter out = new PrintWriter(this.mc.getOutputStream(),true);
		
			//To read from client socket
			BufferedReader in = new BufferedReader(new InputStreamReader(this.mc.getInputStream()));
						
			String clientInput;
		
			out.println("Connected");
			clientInput = in.readLine();
			
			while(clientInput != null ){
				
				System.out.println("Client says : "+clientInput);
				out.println(clientInput);
				if(clientInput.equals("Bye")){
					break;
				}
				
				clientInput = in.readLine();
			}
				
		}catch(SocketException se){
			
			System.out.println("Client Disconnected");
			
		}catch(IOException e){
			
			System.out.println("Cannot read from the socket stream");
						
		}
	}
}
