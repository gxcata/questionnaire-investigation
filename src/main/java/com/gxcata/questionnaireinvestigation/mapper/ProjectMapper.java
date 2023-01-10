package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.PProject;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.vo.ProjectVO;
import com.gxcata.questionnaireinvestigation.vo.QueryProjectByIdVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:17
 */
@Mapper
public interface ProjectMapper extends BaseMapper<PProject> {

    /**
     * 新增项目
     * @param addProjectPO
     * @return
     */
    int add(AddProjectPO addProjectPO);

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
    int updateProject(UpdateProjectPO updateProjectPO);

    /**
     * 删除单位
     * @param deleteProjectPO
     * @return
     */
    int deleteProject(DeleteProjectPO deleteProjectPO);

    /**
     * 根据id查询项目信息
     * @param queryProjectByIdPO
     * @return
     */
    QueryProjectByIdVO queryById(QueryProjectByIdPO queryProjectByIdPO);
}
