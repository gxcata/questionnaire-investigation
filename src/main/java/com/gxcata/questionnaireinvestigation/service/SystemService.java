package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.vo.QuerySystemByIdVO;
import com.gxcata.questionnaireinvestigation.vo.SystemVO;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:45
 */
public interface SystemService {

    /**
     * 新增系统
     * @param addSystemPO
     * @return
     */
    Boolean add(AddSystemPO addSystemPO);

    /**
     * 根据项目id查询所有系统信息
     * @param systemPO
     * @return
     */
    List<SystemVO> querySystemById(SystemPO systemPO);

    /**
     * 修改系统信息
     * @param updateSystemPO
     * @return
     */
    Boolean updateSystem(UpdateSystemPO updateSystemPO);

    /**
     * 删除系统
     * @param deleteSystemPO
     * @return
     */
    Boolean deleteSystem(DeleteSystemPO deleteSystemPO);

    /**
     * 根据id查询系统信息
     * @param querySystemByIdPO
     * @return
     */
    QuerySystemByIdVO queryById(QuerySystemByIdPO querySystemByIdPO);
}
