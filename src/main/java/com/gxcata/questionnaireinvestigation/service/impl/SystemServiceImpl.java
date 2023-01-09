package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.mapper.SystemMapper;
import com.gxcata.questionnaireinvestigation.po.AddSystemPO;
import com.gxcata.questionnaireinvestigation.po.DeleteSystemPO;
import com.gxcata.questionnaireinvestigation.po.SystemPO;
import com.gxcata.questionnaireinvestigation.po.UpdateSystemPO;
import com.gxcata.questionnaireinvestigation.service.SystemService;
import com.gxcata.questionnaireinvestigation.vo.SystemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:46
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Resource
    private SystemMapper systemMapper;

    @Override
    public Boolean add(AddSystemPO addSystemPO) {
        addSystemPO.setSystemId(IdUtil.objectId());
        addSystemPO.setCreateTime(new Date());
        return systemMapper.add(addSystemPO) > 0;
    }

    @Override
    public List<SystemVO> querySystemById(SystemPO systemPO) {
        return systemMapper.querySystemById(systemPO);
    }

    @Override
    public Boolean updateSystem(UpdateSystemPO updateSystemPO) {
        updateSystemPO.setUpdateTime(new Date());
        return systemMapper.updateSystem(updateSystemPO) > 0;
    }

    @Override
    public Boolean deleteSystem(DeleteSystemPO deleteSystemPO) {
        return systemMapper.deleteSystem(deleteSystemPO) > 0;
    }
}
