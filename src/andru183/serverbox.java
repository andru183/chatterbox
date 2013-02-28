package andru183;

import java.io.*;
import java.net.*;

/**
 * Server side of the chat program
 * @author andru
 *
 */
public class serverbox 
{
	//Set the port to listen on
	private static int socket = 9999;
	//Set the run condition
	private static boolean canRun = true;
	
	public static void main(String args[]) 
	{
		//Set up a socket server
		ServerSocket echoServer = null;
		//Print some info
		System.out.println("Starting server socket..");
		//String to hold the clients string later
		String holder;
		//Buffer read to assemble the client info
		BufferedReader Bs;
		//set up socket server
		Socket clientConnectionSocket = null;

		// Try to open a server socket on port $socket
		try 
		{
			//Open echo server on the given socket
			echoServer = new ServerSocket(socket);
			//Print even more info
			System.out.println("Opening socket: " + socket);

		}
		catch (IOException e) 
		{
			System.out.println(e);
		}   

		try {
			
			//Have the clientConnectionSocket listen out for anything incoming on the port
			clientConnectionSocket = echoServer.accept();
			System.out.println("Stream found on port " + socket);
			//Set Bs equal to the incoming stream of info
			Bs = new BufferedReader(new InputStreamReader(clientConnectionSocket.getInputStream()));
			System.out.println("Buffered reader ready...");
			System.out.println("reading.....");

			//so we start with a little bit of space and not packed together
			System.out.println();
			System.out.println();

			//run till we quit
			while (canRun) 
			{
				//put the stream into the string
				holder = Bs.readLine();

				//if what's there is not null
				if(holder != null)
					//print it
					System.out.println(holder);
			}
		}   
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}
}



