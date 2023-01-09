package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import com.gxcata.questionnaireinvestigation.common.jwt.TokenUtils;
import com.gxcata.questionnaireinvestigation.common.utils.JasyptUtil;
import com.gxcata.questionnaireinvestigation.common.utils.StringUtils;
import com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum;
import com.gxcata.questionnaireinvestigation.entity.CUser;
import com.gxcata.questionnaireinvestigation.mapper.UserMapper;
import com.gxcata.questionnaireinvestigation.po.DeleteUserByPhonePO;
import com.gxcata.questionnaireinvestigation.po.LoginPO;
import com.gxcata.questionnaireinvestigation.po.RegisterPO;
import com.gxcata.questionnaireinvestigation.po.UpdateUserByPhonePO;
import com.gxcata.questionnaireinvestigation.service.UserService;
import com.gxcata.questionnaireinvestigation.vo.LoginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghailun
 * @date 2022年12月27日 11:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Override
    public LoginVO login(LoginPO loginPO, HttpServletResponse servletResponse) {
        LoginVO loginVO = new LoginVO();
        CUser cUser = userService.queryUserByPhone(loginPO.getPhoneNumber());
        if(cUser == null && ObjectUtil.isEmpty(cUser)){
            throw new RRException("账号不存在！");
        }
        //解密
        String pwd = JasyptUtil.decrypt(cUser.getSalt(), cUser.getPassword());
        if(!loginPO.getPassword().equals(pwd)){
            throw new RRException("密码不正确！");
        }
        BeanUtil.copyProperties(cUser,loginVO);
        String token = TokenUtils.sign(cUser);
        loginVO.setToken(token);
        servletResponse.setHeader("token",token);
        return loginVO;
    }

    @Override
    public CUser queryUserByPhone(String phone) {
        return userMapper.queryUserByPhone(phone);
    }

    @Override
    public Boolean register(RegisterPO registerPO) {
        //判重
        Map<String,Object> map = new HashMap<>(1);
        map.put("phone_number",registerPO.getPhoneNumber());
        if(CollUtil.isNotEmpty(userMapper.selectByMap(map))){
            throw new RRException(ErrorCodeEnum.ERROR_DATA_REPEAT);
        }

        CUser cUser = new CUser();
        BeanUtil.copyProperties(registerPO,cUser);
        //id
        cUser.setUserId(IdUtil.objectId());
        //创建时间
        cUser.setCreateTime(new Date());
        //密码盐
        String salt = IdUtil.objectId();
        cUser.setSalt(salt);
        //密码进行加密
        String pwd = JasyptUtil.encrypt(salt, cUser.getPassword());
        cUser.setPassword(pwd);
        return userMapper.insert(cUser) > 0;
    }

    @Override
    public Boolean updateUserByPhone(UpdateUserByPhonePO updateUserByPhonePO) {
        //密码
        String password = updateUserByPhonePO.getPassword();
        //不为空才修改
        if(StringUtils.isNotEmpty(password)){
            //盐
            String salt = IdUtil.objectId();
            //密码加密
            String pwd = JasyptUtil.encrypt(salt, password);
            updateUserByPhonePO.setSalt(salt);
            updateUserByPhonePO.setPassword(pwd);
        }
        //修改时间
        updateUserByPhonePO.setUpdateTime(new Date());
        return userMapper.updateUserByPhone(updateUserByPhonePO) > 0;
    }

    @Override
    public Boolean deleteUserByPhone(DeleteUserByPhonePO deleteUserByPhonePO) {
        return userMapper.deleteUserByPhone(deleteUserByPhonePO) > 0;
    }

}
