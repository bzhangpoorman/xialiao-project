package com.bzhang.xialiao.mapper;

import com.bzhang.xialiao.pojo.ScUsers;
import com.bzhang.xialiao.pojo.ScUsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    long countByExample(ScUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    int deleteByExample(ScUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    int insert(ScUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    int insertSelective(ScUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    List<ScUsers> selectByExample(ScUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") ScUsers record, @Param("example") ScUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sc_users
     *
     * @mbg.generated Wed May 08 11:27:00 CST 2019
     */
    int updateByExample(@Param("record") ScUsers record, @Param("example") ScUsersExample example);
}