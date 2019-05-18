package com.bzhang.xialiao.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 创建二维码工具类
 * Created by bzhang on 2019/5/18.
 */
public class QrcodeUtils {


      /**
       * 生成二维码输出流
       * @param os
       * @param content
       * @param format  二维码图片格式
       */
      public static void createQrcode(OutputStream os, String content,String format) {
            int width=300;      		//图片的宽度
            int height=300;     		//图片的高度

            /**
             * 定义二维码的参数
             */
            HashMap hints=new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);  //指定二维码的纠错等级为中级
            hints.put(EncodeHintType.MARGIN, 2);    //设置图片的边距

            /**
             * 生成二维码
             */
            try {
                  BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
                  MatrixToImageWriter.writeToStream(bitMatrix, format,os);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      /**
       * 生成二维码图片文件
       * @param filePath
       * @param content
       * @param format
       */
      public void createQrcode(String filePath, String content,String format) {
            int width=300;      		//图片的宽度
            int height=300;     		//图片的高度

            /**
             * 定义二维码的参数
             */
            HashMap hints=new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);  //指定二维码的纠错等级为中级
            hints.put(EncodeHintType.MARGIN, 2);    //设置图片的边距

            /**
             * 生成二维码
             */
            try {
                  BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
                  Path file=new File(filePath).toPath();
                  MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      /**
       * 自定义生成的二维码图片的大小
       * @param filePath
       * @param content
       * @param format
       * @param height
       * @param width
       */
      public void createQrcode(String filePath, String content,String format,int height,int width) {

            /**
             * 定义二维码的参数
             */
            HashMap hints=new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
            hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);  //指定二维码的纠错等级为中级
            hints.put(EncodeHintType.MARGIN, 2);    //设置图片的边距

            /**
             * 生成二维码
             */
            try {
                  BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
                  Path file=new File(filePath).toPath();
                  MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }


      /**
       * 获取二维码图片中的信息
       * @param filePath
       * @return
       */
      public static String getContentFromQrcode(String filePath) {
            MultiFormatReader formatReader=new MultiFormatReader();
            File file=new File(filePath);
            BufferedImage image;
            try {
                  image = ImageIO.read(file);
                  BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer
                          (new BufferedImageLuminanceSource(image)));
                  HashMap hints=new HashMap();
                  hints.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
                  Result result=formatReader.decode(binaryBitmap,hints);
                  return result.toString();
            } catch (Exception e) {
                  e.printStackTrace();
                  return null;
            }
      }

      /**
       * 从url获取二维码图片中的信息
       * @param url
       * @return
       */
      public static String getContentFromQrcodeURL(URL url) {
            MultiFormatReader formatReader=new MultiFormatReader();
            BufferedImage image;
            try {
                  image = ImageIO.read(url);
                  BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer
                          (new BufferedImageLuminanceSource(image)));
                  HashMap hints=new HashMap();
                  hints.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
                  Result result=formatReader.decode(binaryBitmap,hints);
                  return result.toString();
            } catch (Exception e) {
                  e.printStackTrace();
                  return null;
            }
      }

      /**
       * 从url路径中获取二维码图片中的信息
       * @param url
       * @return
       */
      public static String getContentFromQrcodeURL(String url) {
            try {
                  return getContentFromQrcodeURL(new URL(url));
            } catch (MalformedURLException e) {
                  e.printStackTrace();
                  return null;
            }
      }
}
