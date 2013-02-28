package andru183;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
 * Commenting code rules
 * 1. Be clear, don't use terms like "stuff" or "things" and use the names of objects you are talking about
 * 2. If you're unsure on the exact nature of a line of code, say that when you comment rather than giving miss-information
 * 3. use '$' before variable name to show it's a variable name you're talking about and not a term or object
 * 4. Comment all methods and classes with the /** comment block and details params and returns
 */

/**
 * The client side version of the chat program
 * @author andru
 *
 */
public class chatterbox 
{
	//Server ip address to connect to
	private static final String IPADDRESS = "192.168.0.12";
	//Socket to connect through
	private static final int SOCKET = 9999;
	//Loop conidition
	private static boolean canRun = true;

	public static void main(String[] args) 
	{
		/*
		 * For now have a loop to keep getting user input
		 */
		while(canRun)
		{
			//Create a scanner
			Scanner input = null;
			//read the user input
			input = new Scanner(System.in);
			//store the user input
			String holder = input.next();
			//call send message and pass in $holder
			sendMessage(holder);
			//close the stream
			input.close();
		}

	}

	/**
	 * Send a message to the server
	 * @param msg String Message to send
	 */
	private static void sendMessage(String msg)
	{
		/*
		 * Open socket
		 * Dataoutput stream
		 * Datainput stream
		 */
		Socket smtpSocket = null;  
		DataOutputStream Ds = null;
		DataInputStream Di = null;


		try 
		{
			//Open the socket on $SOCKET and connect to $IPADDRESS
			smtpSocket = new Socket(IPADDRESS, SOCKET);
			//Start the dataoutput stream
			Ds = new DataOutputStream(smtpSocket.getOutputStream());
			//Start the data input stream
			Di = new DataInputStream(smtpSocket.getInputStream());

		} 

		catch (UnknownHostException e) 
		{
			System.err.println("Don't know about host: hostname");
		} 

		catch (IOException e) 
		{
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}






		try 
		{
			/*Please NEVER remove this line of code. 
			 *It was the first string passed to the server and you know the way 
			 *business men sometimes keep their first dollar??
			 */
			//Ds.writeBytes("This might not look like much, but it's the first string I've passed from client to server\n");
			//Convert the message to bytes
			Ds.writeBytes(msg);
			//Close the data out stream
			Ds.close();
			//Close the data in stream
			Di.close();
			//Close the socket and connection
			smtpSocket.close();
			//Print everything went off without a hitch
			System.out.println("no hitch");
		}

		catch (UnknownHostException e) 
		{
			System.err.println("Trying to connect to unknown host: " + e);
		} 

		catch (IOException e) 
		{
			System.err.println("IOException:  " + e);
		}


	}           
}