package com.bzhang.xialiao.netty;

import com.bzhang.xialiao.bean.NettyConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * netty服务器端程序
 * Created by bzhang on 2019/5/8.
 */
@Component
public class ChatServer {
      //主事件循环组，用于接收客户端连接请求，并移交给工作事件循环组处理
      private EventLoopGroup bossGroup;
      //工作事件循环组，用于处理客户端的读写事件
      private EventLoopGroup workerGroup;
      //引导工具类，用于初始化服务
      private ServerBootstrap serverBootstrap;
      //未来结果对象
      private ChannelFuture future;

      //配置信息
      @Autowired
      private NettyConfig nettyConfig;

      /**
       * 懒汉式单例，使用静态内部类的方式实现单例延迟加载
       *//*
      private static class SingletionServer{
            static final ChatServer instance = new ChatServer();
      }

      public static ChatServer getInstance(){
            return SingletionServer.instance;
      }*/

      public ChatServer(){
            init();
      }

      /**
       * 初始化服务器
       */
      private void init() {
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            serverBootstrap = new ServerBootstrap();
            serverBootstrap = this.serverBootstrap.group(bossGroup, workerGroup)
                                                      .channel(NioServerSocketChannel.class)
                                                      .childHandler(new ServerInitialzer());

      }

      /**
       * 启动netty服务
       */
      public void start(){
            try {
                  future = serverBootstrap.bind(nettyConfig.getPort());
                  System.out.println("netty start。。。"+nettyConfig.getPort());
                  //future.channel().close().sync();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }


}
