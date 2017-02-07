package com.codingman.www.socket_io.socketio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Tcp内核的三次握手：
 * 当一个客户端要连接服务器的时候，发送一个SYNC指令给服务器，然后服务器确定端口号和ip地址返回一个SYNCACK标志给客户端，客户端收到后返回ACK报文
 * */
public class SocketServer {
	private final static String ip="127.0.0.1";
	private final static int port=8765;
	public static void main(String[] args) {
		ServerSocket server=null;
		Socket socket=null;
		BufferedReader br=null;
		try {
			System.out.println("接收连接");
			server=new ServerSocket(port);
			socket=server.accept();
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(br.readLine());
			if(br!=null){
				br.close();
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
