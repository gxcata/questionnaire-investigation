package com.gxcata.questionnaireinvestigation.controller;

import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.common.web.page.BaseController;
import com.gxcata.questionnaireinvestigation.po.AddQuestionPO;
import com.gxcata.questionnaireinvestigation.po.DeleteQuestionPO;
import com.gxcata.questionnaireinvestigation.po.UpdateQuestionPO;
import com.gxcata.questionnaireinvestigation.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:09
 */
@RestController
@RequestMapping("/question")
@Api(value = "/question", tags = "问题管理")
@Slf4j
public class QuestionController extends BaseController {

    @Resource
    private QuestionService questionService;

    @UserLoginToken
    @PostMapping("/update")
    @ApiOperation(value = "修改问题信息")
    public Result<Boolean> updateQuestion(@RequestBody @Valid UpdateQuestionPO updateQuestionPO) {
        return Result.ok(questionService.updateQuestion(updateQuestionPO));
    }

    @UserLoginToken
    @PostMapping("/add")
    @ApiOperation(value = "新增问题")
    public Result<Boolean> add(@RequestBody @Valid AddQuestionPO addQuestionPO) {
        return Result.ok(questionService.add(addQuestionPO));
    }

    @UserLoginToken
    @PostMapping("/delete")
    @ApiOperation(value = "删除问题")
    public Result<Boolean> delete(@RequestBody @Valid DeleteQuestionPO deleteQuestionPO) {
        return Result.ok(questionService.delete(deleteQuestionPO));
    }

}
