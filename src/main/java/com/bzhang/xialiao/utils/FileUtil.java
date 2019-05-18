package com.bzhang.xialiao.utils;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by bzhang on 2019/5/12.
 */
public class FileUtil {
      public static MultipartFile fileToMultipart(String filePath) {
            try {
                  // File转换成MutipartFile
                  File file = new File(filePath);
                  FileInputStream inputStream = new FileInputStream(file);
                  MultipartFile multipartFile = new MockMultipartFile(file.getName(), "png", "image/png", inputStream);
                  return multipartFile;
            } catch (IOException e) {
                  e.printStackTrace();
                  return null;
            }
      }

      public static MultipartFile fileToMultipart(String filename,byte[] data) {
            MultipartFile multipartFile = new MockMultipartFile(filename,"png", "image/png",data);
            return multipartFile;
      }
}
