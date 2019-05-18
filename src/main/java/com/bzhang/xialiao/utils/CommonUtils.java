package com.bzhang.xialiao.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 通用工具类
 * Created by bzhang on 2019/5/18.
 */
public class CommonUtils {

      /**
       * 关闭文件，流，通道等对象
       * @param cs
       */
      public static void close(Closeable... cs){
            for (Closeable c:cs) {
                  if (c!=null){
                        try {
                              c.close();
                        } catch (IOException e) {
                              e.printStackTrace();
                        }
                  }
            }
      }
}
