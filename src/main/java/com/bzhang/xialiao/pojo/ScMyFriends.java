package com.bzhang.xialiao.pojo;

public class ScMyFriends {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_my_friends.id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_my_friends.my_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    private String myUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_my_friends.friend_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    private String friendUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_my_friends.is_black
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    private Byte isBlack;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_my_friends.id
     *
     * @return the value of sc_my_friends.id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_my_friends.id
     *
     * @param id the value for sc_my_friends.id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_my_friends.my_user_id
     *
     * @return the value of sc_my_friends.my_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public String getMyUserId() {
        return myUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_my_friends.my_user_id
     *
     * @param myUserId the value for sc_my_friends.my_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_my_friends.friend_user_id
     *
     * @return the value of sc_my_friends.friend_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public String getFriendUserId() {
        return friendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_my_friends.friend_user_id
     *
     * @param friendUserId the value for sc_my_friends.friend_user_id
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public void setFriendUserId(String friendUserId) {
        this.friendUserId = friendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_my_friends.is_black
     *
     * @return the value of sc_my_friends.is_black
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public Byte getIsBlack() {
        return isBlack;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_my_friends.is_black
     *
     * @param isBlack the value for sc_my_friends.is_black
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    public void setIsBlack(Byte isBlack) {
        this.isBlack = isBlack;
    }
}