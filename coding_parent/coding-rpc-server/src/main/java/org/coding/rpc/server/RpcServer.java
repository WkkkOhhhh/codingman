package org.coding.rpc.server;


import java.util.HashMap;
import java.util.Map;


import org.apache.commons.collections4.MapUtils;
import org.coding.rpc.annotation.RpcService;
import org.coding.rpc.common.RpcDecoder;
import org.coding.rpc.common.RpcEncoder;
import org.coding.rpc.common.RpcRequest;
import org.coding.rpc.common.RpcResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class RpcServer implements ApplicationContextAware, InitializingBean {
	
	private String serverAddress;
	private ServiceRegistry serviceRegistry;
	
	private Map<String, Object> handlerMap=new HashMap<String, Object>();

	public RpcServer(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public RpcServer(String serverAddress, ServiceRegistry serviceRegistry) {
		this.serverAddress = serverAddress;
		this.serviceRegistry = serviceRegistry;
	}

	public void afterPropertiesSet() throws Exception {
		 EventLoopGroup bossGroup = new NioEventLoopGroup();
	     EventLoopGroup workerGroup = new NioEventLoopGroup();
	        try {
	            ServerBootstrap bootstrap = new ServerBootstrap();
	            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
	                    @Override
	                    public void initChannel(SocketChannel channel) throws Exception {
	                        ((Channel) channel).pipeline()
	                            .addLast(new RpcDecoder(RpcRequest.class)) // 将 RPC 请求进行解码（为了处理请求）
	                            .addLast(new RpcEncoder(RpcResponse.class)) // 将 RPC 响应进行编码（为了返回响应）
	                            .addLast(new RpcHandler(handlerMap)); // 处理 RPC 请求
	                    }
	                })
	                .option(ChannelOption.SO_BACKLOG, 128)
	                .childOption(ChannelOption.SO_KEEPALIVE, true);

	            String[] array = serverAddress.split(":");
	            String host = array[0];
	            int port = Integer.parseInt(array[1]);

	            ChannelFuture future = bootstrap.bind(host, port).sync();
	            //LOGGER.debug("server started on port {}", port);

	            if (serviceRegistry != null) {
	                serviceRegistry.register(serverAddress); // 注册服务地址
	            }

	            future.channel().closeFuture().sync();
	        } finally {
	            workerGroup.shutdownGracefully();
	            bossGroup.shutdownGracefully();
	        }

	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		Map<String, Object> serviceBeanMap=ctx.getBeansWithAnnotation(RpcService.class);
		if(MapUtils.isNotEmpty(serviceBeanMap)){
			for (Object serviceBean : serviceBeanMap.values()) {
				String interfaceName = serviceBean.getClass().getAnnotation(RpcService.class).value().getName();
                handlerMap.put(interfaceName, serviceBean);
			}
		}
	}

}
