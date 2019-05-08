package com.bzhang.xialiao.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 *
 * Created by bzhang on 2019/5/8.
 */
public class ServerInitialzer  extends ChannelInitializer<SocketChannel>{
      @Override
      protected void initChannel(SocketChannel channel) throws Exception {
            ChannelPipeline pipeline = channel.pipeline();
            pipeline.addLast(new HttpServerCodec());
            pipeline.addLast(new ChunkedWriteHandler());
            pipeline.addLast(new HttpObjectAggregator(8192));
            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

            pipeline.addLast(new TestHandler());
      }
}
