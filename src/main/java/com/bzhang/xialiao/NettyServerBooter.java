package com.bzhang.xialiao;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring的事件监听，用于启动netty服务器
 * Created by bzhang on 2019/5/8.
 */
@Component
public class NettyServerBooter implements ApplicationListener<ContextRefreshedEvent> {
      @Override
      public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            /*if(contextRefreshedEvent.getApplicationContext().getParent()==null){
                  ChatServer.getInstance().start();
            }*/
      }
}
