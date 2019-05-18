package com.bzhang.xialiao.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 图片处理工具类，主要压缩，添加logo等
 * @author 张瑶
 */
public class ImageUtil {

      public static void main(String[] args) {
            //使用给定的图片生成指定大小的图片
            //generateFixedSizeImage();

            //对原图加水印,然后顺时针旋转90度,最后压缩为80%保存
            //generateRotationWatermark();

            //转换图片格式,将流写入到输出流
            //generateOutputstream();

            //按比例缩放图片
            //generateScale();

            //生成缩略图到指定的目录
            //generateThumbnail2Directory();

            //将指定目录下所有图片生成缩略图
            //generateDirectoryThumbnail();
      }

      /**
       * 使用给定的图片生成指定大小的图片
       */
      public static MultipartFile generateFixedSizeImage(MultipartFile file,int size) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                  String addname = "_"+size+"x"+size;
                  String[] split = file.getName().split("\\u002E");
                  System.out.println(file.getName()+split.length);
                  String newName = split[0]+addname+"."+split[1];

                  Thumbnails.of(file.getInputStream()).size(size, size).toOutputStream(baos);

                  return new MockMultipartFile(newName,split[1],"image/"+split[1],baos.toByteArray());
            } catch (IOException e) {
                  e.printStackTrace();
            }finally {
                  CommonUtils.close(baos);
            }
            return null;
      }

}