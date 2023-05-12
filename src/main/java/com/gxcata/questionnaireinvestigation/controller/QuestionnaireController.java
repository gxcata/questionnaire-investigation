package com.gxcata.questionnaireinvestigation.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.common.web.page.BaseController;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.service.QuestionnaireService;
import com.gxcata.questionnaireinvestigation.vo.QueryQuestionnaireByIdVO;
import com.gxcata.questionnaireinvestigation.vo.QuestionnaireVO;
import com.gxcata.questionnaireinvestigation.vo.StatisticsQuestionnaireVO;
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
 * @date 2022年12月31日 9:56
 */
@RestController
@RequestMapping("/questionnaire")
@Api(value = "/questionnaire", tags = "问卷管理")
@Slf4j
public class QuestionnaireController extends BaseController {

    @Resource
    private QuestionnaireService questionnaireService;

    @UserLoginToken
    @PostMapping("/addTemplate")
    @ApiOperation(value = "新增问卷模板")
    public Result<Boolean> addTemplate(@RequestBody @Valid AddQuestionnaireTemplatePO addQuestionnaireTemplatePO) {
        AddQuestionnairePO addQuestionnairePO = new AddQuestionnairePO();
        BeanUtil.copyProperties(addQuestionnairePO,addQuestionnaireTemplatePO);
        return Result.ok(questionnaireService.add(addQuestionnairePO));
    }

    @UserLoginToken
    @PostMapping("/add")
    @ApiOperation(value = "新增问卷")
    public Result<Boolean> add(@RequestBody @Valid AddQuestionnairePO addQuestionnairePO) {
        return Result.ok(questionnaireService.add(addQuestionnairePO));
    }


    @UserLoginToken
    @PostMapping("/query")
    @ApiOperation(value = "根据状态查询问卷or模板列表")
    public Result<List<QuestionnaireVO>> query(@RequestBody @Valid QuestionnairePO questionnairePO) {
        startPage();
        return getDataTable(questionnaireService.query(questionnairePO));
    }

    @UserLoginToken
    @PostMapping("/update")
    @ApiOperation(value = "修改问卷信息")
    public Result<Boolean> update(@RequestBody @Valid UpdateQuestionnairePO updateQuestionnairePO) {
        return Result.ok(questionnaireService.update(updateQuestionnairePO));
    }


    @PostMapping("/queryById")
    @ApiOperation(value = "根据id查询问卷or模板详情")
    public Result<QueryQuestionnaireByIdVO> queryById(@RequestBody @Valid QueryQuestionnaireByIdPO queryQuestionnaireByIdPO) {
        return Result.ok(questionnaireService.queryById(queryQuestionnaireByIdPO));
    }

    @UserLoginToken
    @PostMapping("/delete")
    @ApiOperation(value = "删除问卷or模板")
    public Result<Boolean> delete(@RequestBody @Valid DeleteQuestionnairePO deleteQuestionnairePO) {
        return Result.ok(questionnaireService.delete(deleteQuestionnairePO));
    }

    @UserLoginToken
    @PostMapping("/generatedUrl")
    @ApiOperation(value = "生成链接")
    public Result<Boolean> generatedUrl(@RequestBody @Valid GeneratedUrlPO generatedUrlPO) {
        return Result.ok(questionnaireService.generatedUrl(generatedUrlPO));
    }

    @PostMapping("/writeQuestionnaire")
    @ApiOperation(value = "填写问卷")
    public Result<Boolean> writeQuestionnaire(@RequestBody @Valid List<WriteQuestionnairePO> writeQuestionnairePOList) {
        return Result.ok(questionnaireService.writeQuestionnaire(writeQuestionnairePOList));
    }

    @UserLoginToken
    @PostMapping("/statistics")
    @ApiOperation(value = "问卷统计")
    public Result<StatisticsQuestionnaireVO> statistics(@RequestBody @Valid StatisticsQuestionnairePO statisticsQuestionnairePO) {
        return Result.ok(questionnaireService.statistics(statisticsQuestionnairePO));
    }

}
