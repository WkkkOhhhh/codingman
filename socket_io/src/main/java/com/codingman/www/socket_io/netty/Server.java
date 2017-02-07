package com.codingman.www.socket_io.netty;

import java.net.InetSocketAddress;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty的主要组成模块 ---------- netty是基于nio的 非阻塞网络框架 ----------
 * channel（通道）：带表了一个链接，也可理解为输入和输出数据的媒介
 * Callbacks（回调）：回调在异步编程中经常被使用，不细说拉。当callback被触发的时候，事件可以被ChannelHandler的接口处理，
 * 这个接口一般处理详细的业务逻辑，即使给handler一个通知，告诉他 你可以操作你的方法了。
 * Futures：提供了领一个当操作完成时如何通知应用的方法。因为Channelhandler操作方法完成后，肯定是要给客户端一个回应，也可以理解为结果。
 * Future就给这个结果把位置占好，如果这个异步操作完成拉，它就提供对操作结果的访问
 * Events和handlers：netty用细分的events来通知我们状态的变化或者操作的状况，比如日志记录、数据传送、流控制、应用逻辑等
 */
public class Server {
	private final int port;

	public Server(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		if(args.length!=1){
			System.err.println("Usage:"+Server.class.getSimpleName());//返回类名
		}
		int port=Integer.parseInt(args[0]);
		new Server(port).start();
	}

	public void start() throws Exception {
		final ServerHanlder serverHanlder=new ServerHanlder();
		EventLoopGroup workGroup=new NioEventLoopGroup();
		try {
			ServerBootstrap b=new ServerBootstrap();
			b.group(workGroup).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(serverHanlder);
					
				}
			});
			ChannelFuture future=b.bind().sync();
			future.channel().closeFuture().sync();
		} finally {
			workGroup.shutdownGracefully().sync();
		}
		
	}
}
