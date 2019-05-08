package com.bzhang.xialiao.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * netty服务器配置
 * Created by bzhang on 2019/5/8.
 */
@Component
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
      private int port;
      private String host;

      public int getPort() {
            return port;
      }

      public void setPort(int port) {
            this.port = port;
      }

      public String getHost() {
            return host;
      }

      public void setHost(String host) {
            this.host = host;
      }
}
