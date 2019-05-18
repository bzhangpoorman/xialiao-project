package com.bzhang.xialiao.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件上传到图片服务器用到的参数
 * Created by bzhang on 2019/5/12.
 */
@Component
@ConfigurationProperties(prefix = "fileconfig")
public class FileConfig {
      private String host;
      private int port;
      private String username;
      private String password;
      private String basepath;
      private String filepath;
      private int size;
      private String format;

      public String getFormat() {
            return format;
      }

      public void setFormat(String format) {
            this.format = format;
      }

      public int getSize() {
            return size;
      }

      public void setSize(int size) {
            this.size = size;
      }

      public String getHost() {
            return host;
      }

      public void setHost(String host) {
            this.host = host;
      }

      public int getPort() {
            return port;
      }

      public void setPort(int port) {
            this.port = port;
      }

      public String getUsername() {
            return username;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getBasepath() {
            return basepath;
      }

      public void setBasepath(String basepath) {
            this.basepath = basepath;
      }

      public String getFilepath() {
            return filepath;
      }

      public void setFilepath(String filepath) {
            this.filepath = filepath;
      }
}
