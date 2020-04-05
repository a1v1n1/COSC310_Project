package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatbotSocket {
	public Socket socket;
	public PrintWriter output;
	public BufferedReader input;
	
	public ChatbotSocket() throws UnknownHostException, IOException {
		socket = new Socket("50.92.82.253", 25565);
		output = new PrintWriter(socket.getOutputStream(), true);
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public String send(String msg) throws IOException {
		return input.readLine();
	}
	
	public void close() throws IOException {
		output.close();
		input.close();
		socket.close();
	}
}
