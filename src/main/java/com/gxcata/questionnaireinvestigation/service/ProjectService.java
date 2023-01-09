package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.po.AddProjectPO;
import com.gxcata.questionnaireinvestigation.po.DeleteProjectPO;
import com.gxcata.questionnaireinvestigation.po.ProjectPO;
import com.gxcata.questionnaireinvestigation.po.UpdateProjectPO;
import com.gxcata.questionnaireinvestigation.vo.ProjectVO;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:13
 */
public interface ProjectService {

    /**
     * 新增项目
     * @param addProjectPO
     * @return
     */
    Boolean add(AddProjectPO addProjectPO);

    /**
     * 根据单位id查询所有项目信息
     * @param projectPO
     * @return
     */
    List<ProjectVO> queryProjectById(ProjectPO projectPO);

    /**
     * 修改项目信息
     * @param updateProjectPO
     * @return
     */
    Boolean updateProject(UpdateProjectPO updateProjectPO);

    /**
     * 删除单位
     * @param deleteProjectPO
     * @return
     */
    Boolean deleteProject(DeleteProjectPO deleteProjectPO);
}
