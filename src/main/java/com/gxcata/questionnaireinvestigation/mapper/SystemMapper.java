package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.SSystem;
import com.gxcata.questionnaireinvestigation.po.AddSystemPO;
import com.gxcata.questionnaireinvestigation.po.DeleteSystemPO;
import com.gxcata.questionnaireinvestigation.po.SystemPO;
import com.gxcata.questionnaireinvestigation.po.UpdateSystemPO;
import com.gxcata.questionnaireinvestigation.vo.SystemVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月30日 9:36
 */
@Mapper
public interface SystemMapper extends BaseMapper<SSystem> {

    /**
     * 新增系统
     * @param addSystemPO
     * @return
     */
    int add(AddSystemPO addSystemPO);

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
    int updateSystem(UpdateSystemPO updateSystemPO);

    /**
     * 删除系统信息
     * @param deleteSystemPO
     * @return
     */
    int deleteSystem(DeleteSystemPO deleteSystemPO);
}
