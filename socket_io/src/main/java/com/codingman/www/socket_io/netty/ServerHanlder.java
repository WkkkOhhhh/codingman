package com.codingman.www.socket_io.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

//这里将处理详细的业务逻辑
//表示次对象在channel间共享
//特别注意这个注解@Sharable，默认的4版本不能自动导入匹配的包，需要手动加入
//地址是import io.netty.channel.ChannelHandler.Sharable;
@Sharable
public class ServerHanlder extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf in = (ByteBuf) msg;
		System.out.println("Server receive" + in.toString(CharsetUtil.UTF_8));
		ctx.write(in);
	}

	// 将刷新挂起的数据发送到远端然后关闭channel
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}

	// 处理异常s
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
