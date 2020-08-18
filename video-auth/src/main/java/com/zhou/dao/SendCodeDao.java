package com.zhou.dao;


import com.zhou.entity.SendCode;
import org.apache.ibatis.annotations.Select;

public interface SendCodeDao {

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insert(SendCode sendCode);


    /**
     * 新增数据
     *
     */
    @Select("SELECT * FROM tb_sms_code WHERE mobile = '17320406595' AND `status` = -1 ORDER BY send_time DESC LIMIT 1")
    SendCode findByMobile(String phone);
}