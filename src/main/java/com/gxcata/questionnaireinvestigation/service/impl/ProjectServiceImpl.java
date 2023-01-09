package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.mapper.ProjectMapper;
import com.gxcata.questionnaireinvestigation.po.AddProjectPO;
import com.gxcata.questionnaireinvestigation.po.DeleteProjectPO;
import com.gxcata.questionnaireinvestigation.po.ProjectPO;
import com.gxcata.questionnaireinvestigation.po.UpdateProjectPO;
import com.gxcata.questionnaireinvestigation.service.ProjectService;
import com.gxcata.questionnaireinvestigation.vo.ProjectVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:13
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Boolean add(AddProjectPO addProjectPO) {
        addProjectPO.setProjectId(IdUtil.objectId());
        addProjectPO.setCreateTime(new Date());
        return projectMapper.add(addProjectPO) > 0;
    }

    @Override
    public List<ProjectVO> queryProjectById(ProjectPO projectPO) {
        return projectMapper.queryProjectById(projectPO);
    }

    @Override
    public Boolean updateProject(UpdateProjectPO updateProjectPO) {
        updateProjectPO.setUpdateTime(new Date());
        return projectMapper.updateProject(updateProjectPO) > 0;
    }

    @Override
    public Boolean deleteProject(DeleteProjectPO deleteProjectPO) {
        return projectMapper.deleteProject(deleteProjectPO) > 0;
    }
}
