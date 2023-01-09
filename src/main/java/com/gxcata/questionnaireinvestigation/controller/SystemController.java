package com.gxcata.questionnaireinvestigation.controller;

import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.common.web.page.BaseController;
import com.gxcata.questionnaireinvestigation.po.AddSystemPO;
import com.gxcata.questionnaireinvestigation.po.DeleteSystemPO;
import com.gxcata.questionnaireinvestigation.po.SystemPO;
import com.gxcata.questionnaireinvestigation.po.UpdateSystemPO;
import com.gxcata.questionnaireinvestigation.service.SystemService;
import com.gxcata.questionnaireinvestigation.vo.SystemVO;
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
@RequestMapping("/system")
@Api(value = "/system", tags = "系统管理")
@Slf4j
public class SystemController extends BaseController {

    @Resource
    private SystemService systemService;

    @UserLoginToken
    @PostMapping("/add")
    @ApiOperation(value = "新增系统")
    public Result<Boolean> add(@RequestBody @Valid AddSystemPO addSystemPO) {
        return Result.ok(systemService.add(addSystemPO));
    }

    @UserLoginToken
    @PostMapping("/querySystemById")
    @ApiOperation(value = "根据项目id查询所有系统信息")
    public Result<List<SystemVO>> querySystemById(@RequestBody @Valid SystemPO systemPO) {
        startPage();
        return getDataTable(systemService.querySystemById(systemPO));
    }

    @UserLoginToken
    @PostMapping("/updateSystem")
    @ApiOperation(value = "修改系统信息")
    public Result<Boolean> updateSystem(@RequestBody @Valid UpdateSystemPO updateSystemPO) {
        return Result.ok(systemService.updateSystem(updateSystemPO));
    }

    @UserLoginToken
    @PostMapping("/deleteSystem")
    @ApiOperation(value = "删除系统")
    public Result<Boolean> deleteSystem(@RequestBody @Valid DeleteSystemPO deleteSystemPO) {
        return Result.ok(systemService.deleteSystem(deleteSystemPO));
    }


}
