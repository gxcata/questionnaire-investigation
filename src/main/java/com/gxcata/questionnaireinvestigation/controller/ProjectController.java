package com.gxcata.questionnaireinvestigation.controller;

import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.common.web.page.BaseController;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.service.ProjectService;
import com.gxcata.questionnaireinvestigation.vo.ProjectVO;
import com.gxcata.questionnaireinvestigation.vo.QueryProjectByIdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:09
 */
@RestController
@RequestMapping("/project")
@Api(value = "/project", tags = "项目管理")
@Slf4j
public class ProjectController extends BaseController {

    @Resource
    private ProjectService projectService;

    @UserLoginToken
    @PostMapping("/add")
    @ApiOperation(value = "新增项目")
    public Result<Boolean> add(@RequestBody @Valid AddProjectPO addProjectPO) {
        return Result.ok(projectService.add(addProjectPO));
    }

    @UserLoginToken
    @PostMapping("/queryProjectById")
    @ApiOperation(value = "根据单位id查询所有项目信息")
    public Result<List<ProjectVO>> queryProjectById(@RequestBody @Valid ProjectPO projectPO) {
        startPage();
        return getDataTable(projectService.queryProjectById(projectPO));
    }

    @UserLoginToken
    @PostMapping("/updateProject")
    @ApiOperation(value = "修改项目信息")
    public Result<Boolean> updateProject(@RequestBody @Valid UpdateProjectPO updateProjectPO) {
        return Result.ok(projectService.updateProject(updateProjectPO));
    }

    @UserLoginToken
    @PostMapping("/deleteProject")
    @ApiOperation(value = "删除项目")
    public Result<Boolean> deleteProject(@RequestBody @Valid DeleteProjectPO deleteProjectPO) {
        return Result.ok(projectService.deleteProject(deleteProjectPO));
    }

    @UserLoginToken
    @PostMapping("/queryById")
    @ApiOperation(value = "根据id查询项目信息")
    public Result<QueryProjectByIdVO> queryById(@RequestBody @Valid QueryProjectByIdPO queryProjectByIdPO) {
        return Result.ok(projectService.queryById(queryProjectByIdPO));
    }


}
