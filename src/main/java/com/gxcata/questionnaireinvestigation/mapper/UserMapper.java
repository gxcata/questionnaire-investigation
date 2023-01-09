package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.CUser;
import com.gxcata.questionnaireinvestigation.po.DeleteUserByPhonePO;
import com.gxcata.questionnaireinvestigation.po.UpdateUserByPhonePO;
import org.mapstruct.Mapper;

/**
 * @author wanghailun
 * @date 2022年12月27日 11:17
 */
@Mapper
public interface UserMapper extends BaseMapper<CUser> {

    /**
     * 根据电话号码查询用户信息
     * @param phone
     * @return
     */
    CUser queryUserByPhone(String phone);

    /**
     * 根据手机号码修改用户信息
     * @param updateUserByPhonePO
     * @return
     */
    int updateUserByPhone(UpdateUserByPhonePO updateUserByPhonePO);

    /**
     * 根据手机号码删除用户
     * @param deleteUserByPhonePO
     * @return
     */
    int deleteUserByPhone(DeleteUserByPhonePO deleteUserByPhonePO);
}
