package com.bzhang.xialiao.pojo;

import java.util.Date;

public class ScChatMsg {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.send_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private String sendUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.accept_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private String acceptUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.msg
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private String msg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.sign_flag
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private Byte signFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_chat_msg.created
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    private Date created;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.id
     *
     * @return the value of sc_chat_msg.id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.id
     *
     * @param id the value for sc_chat_msg.id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.send_user_id
     *
     * @return the value of sc_chat_msg.send_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.send_user_id
     *
     * @param sendUserId the value for sc_chat_msg.send_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.accept_user_id
     *
     * @return the value of sc_chat_msg.accept_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public String getAcceptUserId() {
        return acceptUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.accept_user_id
     *
     * @param acceptUserId the value for sc_chat_msg.accept_user_id
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.msg
     *
     * @return the value of sc_chat_msg.msg
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.msg
     *
     * @param msg the value for sc_chat_msg.msg
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.sign_flag
     *
     * @return the value of sc_chat_msg.sign_flag
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public Byte getSignFlag() {
        return signFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.sign_flag
     *
     * @param signFlag the value for sc_chat_msg.sign_flag
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setSignFlag(Byte signFlag) {
        this.signFlag = signFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_chat_msg.created
     *
     * @return the value of sc_chat_msg.created
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_chat_msg.created
     *
     * @param created the value for sc_chat_msg.created
     *
     * @mbg.generated Tue May 21 11:02:46 CST 2019
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}