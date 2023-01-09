package com.gxcata.questionnaireinvestigation.controller;

import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.common.web.page.BaseController;
import com.gxcata.questionnaireinvestigation.po.AddCompanyPO;
import com.gxcata.questionnaireinvestigation.po.CompanyPO;
import com.gxcata.questionnaireinvestigation.po.DeleteCompanyPO;
import com.gxcata.questionnaireinvestigation.po.UpdateCompanyPO;
import com.gxcata.questionnaireinvestigation.service.CompanyService;
import com.gxcata.questionnaireinvestigation.vo.CompanyVO;
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
@RequestMapping("/company")
@Api(value = "/company", tags = "单位管理")
@Slf4j
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;

    @UserLoginToken
    @PostMapping("/add")
    @ApiOperation(value = "新增单位")
    public Result<Boolean> add(@RequestBody @Valid AddCompanyPO addCompanyPO) {
        return Result.ok(companyService.add(addCompanyPO));
    }

    @UserLoginToken
    @PostMapping("/queryCompany")
    @ApiOperation(value = "查询所有单位信息")
    public Result<List<CompanyVO>> queryCompany(@RequestBody CompanyPO companyPO) {
        startPage();
        return getDataTable(companyService.queryCompany(companyPO));
    }

    @UserLoginToken
    @PostMapping("/updateCompany")
    @ApiOperation(value = "修改单位信息")
    public Result<Boolean> updateCompany(@RequestBody @Valid UpdateCompanyPO updateCompanyPO) {
        return Result.ok(companyService.updateCompany(updateCompanyPO));
    }

    @UserLoginToken
    @PostMapping("/deleteCompany")
    @ApiOperation(value = "删除单位")
    public Result<Boolean> deleteCompany(@RequestBody @Valid DeleteCompanyPO deleteCompanyPO) {
        return Result.ok(companyService.deleteCompany(deleteCompanyPO));
    }

}
