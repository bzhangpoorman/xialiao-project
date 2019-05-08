package com.bzhang.xialiao.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * 处理器
 * Created by bzhang on 2019/5/8.
 */
public class TestHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

      @Override
      protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
            System.out.println("收到消息： " + msg.text());

            ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间： " + LocalDateTime.now()));
      }

      @Override
      public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("异常发生");
            ctx.close();
      }
}
