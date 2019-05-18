package com.bzhang.xialiao.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 生成二维码图片所需参数
 * Created by bzhang on 2019/5/18.
 */
@Component
@ConfigurationProperties(prefix = "qrcodeconfig")
public class QrcodeConfig {
      private String prefixContent;
      private String format;

      public String getFormat() {
            return format;
      }

      public void setFormat(String format) {
            this.format = format;
      }

      public String getPrefixContent() {
            return prefixContent;
      }

      public void setPrefixContent(String prefixContent) {
            this.prefixContent = prefixContent;
      }
}
