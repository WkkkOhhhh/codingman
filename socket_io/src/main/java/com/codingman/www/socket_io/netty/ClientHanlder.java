package com.codingman.www.socket_io.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.CharsetUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Sharable
public class ClientHanlder extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

	}

	// 处理异常s
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		System.out.println("Client receive" + in.toString(CharsetUtil.UTF_8));
	}

}
