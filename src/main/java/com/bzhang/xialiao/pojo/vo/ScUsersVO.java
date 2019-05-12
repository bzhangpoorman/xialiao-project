package com.bzhang.xialiao.pojo.vo;

import com.bzhang.xialiao.pojo.ScUsers;

/**
 * 用与前端交换的用户对象
 * Created by bzhang on 2019/5/9.
 */
public class ScUsersVO {
      private String id;

      private String username;

      private String faceImage;

      private String faceImageBig;

      private String nickname;

      private String qrcode;

      /**
       * 根据ScUsers对象组装ScUsersVO对象
       * @param user
       * @return
       */
      public static ScUsersVO getScUsersVO(ScUsers user){
            ScUsersVO scUsersVO = new ScUsersVO();
            scUsersVO.setId(user.getId());
            scUsersVO.setUsername(user.getUsername());
            scUsersVO.setQrcode(user.getQrcode());
            scUsersVO.setFaceImage(user.getFaceImage());
            scUsersVO.setFaceImageBig(user.getFaceImageBig());
            scUsersVO.setNickname(user.getNickname());
            return scUsersVO;
      }

      public String getId() {
            return id;
      }

      public void setId(String id) {
            this.id = id;
      }

      public String getUsername() {
            return username;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getFaceImage() {
            return faceImage;
      }

      public void setFaceImage(String faceImage) {
            this.faceImage = faceImage;
      }

      public String getFaceImageBig() {
            return faceImageBig;
      }

      public void setFaceImageBig(String faceImageBig) {
            this.faceImageBig = faceImageBig;
      }

      public String getNickname() {
            return nickname;
      }

      public void setNickname(String nickname) {
            this.nickname = nickname;
      }

      public String getQrcode() {
            return qrcode;
      }

      public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
      }
}
