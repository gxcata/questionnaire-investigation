package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.entity.CUser;
import com.gxcata.questionnaireinvestigation.po.DeleteUserByPhonePO;
import com.gxcata.questionnaireinvestigation.po.LoginPO;
import com.gxcata.questionnaireinvestigation.po.RegisterPO;
import com.gxcata.questionnaireinvestigation.po.UpdateUserByPhonePO;
import com.gxcata.questionnaireinvestigation.vo.LoginVO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wanghailun
 * @date 2022年12月27日 11:14
 */
public interface UserService {

    /**
     * 用户登录
     * @param loginPO
     * @return
     */
    LoginVO login(LoginPO loginPO, HttpServletResponse servletResponse);

    /**
     * 查询用户信息根据手机号码
     * @param phone
     * @return
     */
    CUser queryUserByPhone(String phone);

    /**
     * 用户注册
     * @param registerPO
     * @return
     */
    Boolean register(RegisterPO registerPO);

    /**
     * 根据手机号码修改用户信息
     * @param updateUserByPhonePO
     * @return
     */
    Boolean updateUserByPhone(UpdateUserByPhonePO updateUserByPhonePO);

    /**
     * 根据手机号码删除用户
     * @param deleteUserByPhonePO
     * @return
     */
    Boolean deleteUserByPhone(DeleteUserByPhonePO deleteUserByPhonePO);
}
