package org.icase.distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOClient {
	public static void start() throws UnknownHostException, IOException{
		
		Socket socket = new Socket("127.0.0.1", 9000);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		System.out.println(reader.readLine());
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println("Hello Server");
		out.flush();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		BIOClient.start();
	}
}
