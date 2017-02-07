package com.codingman.www.socket_io.netty;

import java.net.InetSocketAddress;
import com.codingman.www.socket_io.netty.*;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	private final String host;
	private final int port;

	public Client(String host,int port) {
		this.host=host;
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(args.length);d
		if(args.length!=2){
			System.err.println("Usage:"+Server.class.getSimpleName());//返回类名
		}
		String host=args[0];
		int port=Integer.parseInt(args[1]);
		new Client(host,port).start();
	}

	public void start() throws Exception {
		EventLoopGroup workGroup=new NioEventLoopGroup();
		try {
			Bootstrap b=new Bootstrap();
			b.group(workGroup).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host,port)).handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ClientHanlder());
					
				}
			});
			ChannelFuture future=b.connect().sync();
			future.channel().closeFuture().sync();
		} finally {
			workGroup.shutdownGracefully().sync();
		}
		
	}
}
