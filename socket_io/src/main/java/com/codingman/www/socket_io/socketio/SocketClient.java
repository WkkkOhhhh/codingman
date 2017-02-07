package com.codingman.www.socket_io.socketio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {
	private final static String ip="127.0.0.1";
	private final static int port=8765;
	public static void main(String[] args) {
		Socket client=null;
		PrintWriter pw=null;
		try {
			client=new Socket(ip, port);
			String str="发送数据至server";
			pw=new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			pw.write(str);
			if(pw!=null){
				pw.close();
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
