package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.common.enums.GenerateStatusEnum;
import com.gxcata.questionnaireinvestigation.common.enums.QuestionTypeEnum;
import com.gxcata.questionnaireinvestigation.common.enums.StatusCodeEnum;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum;
import com.gxcata.questionnaireinvestigation.entity.QAnswer;
import com.gxcata.questionnaireinvestigation.entity.QOption;
import com.gxcata.questionnaireinvestigation.entity.QQuestion;
import com.gxcata.questionnaireinvestigation.mapper.AnswerMapper;
import com.gxcata.questionnaireinvestigation.mapper.OptionMapper;
import com.gxcata.questionnaireinvestigation.mapper.QuestionMapper;
import com.gxcata.questionnaireinvestigation.mapper.QuestionnaireMapper;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.service.QuestionnaireService;
import com.gxcata.questionnaireinvestigation.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wanghailun
 * @date 2022年12月31日 9:59
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Resource
    private QuestionnaireMapper questionnaireMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private OptionMapper optionMapper;

    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private QuestionnaireService questionnaireService;

    @Override
    public Boolean add(AddQuestionnairePO addQuestionnairePO) {
        //生成id
        addQuestionnairePO.setQuestionnaireId(IdUtil.objectId());
        //创建时间
        addQuestionnairePO.setCreateTime(new Date());

        if(CollUtil.isNotEmpty(addQuestionnairePO.getList())){
            //获取传参
            List<AddQuestionPO> list = addQuestionnairePO.getList();
            //遍历，循环添加
            for(AddQuestionPO po : list){
                //生成id
                po.setQuestionId(IdUtil.objectId());
                //关联id
                po.setQuestionnaireId(addQuestionnairePO.getQuestionnaireId());
                //默认启用
                po.setStatusCode(StatusCodeEnum.ENABLE.getVal());
                List<AddOptionPO> optionList = po.getList();
                if(CollUtil.isNotEmpty(optionList)){
                    for(AddOptionPO option : optionList){
                        //默认启用
                        option.setStatusCode(StatusCodeEnum.ENABLE.getVal());
                        option.setOptionId(IdUtil.objectId());
                        option.setQuestionId(po.getQuestionId());
                    }
                    if(optionMapper.add(optionList) <= 0){
                        throw new RRException(ErrorCodeEnum.ERROR_ADD);
                    }
                }
            }
            if(questionMapper.add(list) <= 0){
                throw new RRException(ErrorCodeEnum.ERROR_ADD);
            }
        }
        return questionnaireMapper.add(addQuestionnairePO) > 0;
    }

    @Override
    public List<QuestionnaireVO> query(QuestionnairePO questionnairePO) {
        return questionnaireMapper.query(questionnairePO);
    }

    @Override
    public boolean update(UpdateQuestionnairePO updateQuestionnairePO) {

        updateQuestionnairePO.setUpdateTime(new Date());

        return questionnaireMapper.updateQuestionnaire(updateQuestionnairePO) > 0;
    }

    @Override
    public QueryQuestionnaireByIdVO queryById(QueryQuestionnaireByIdPO queryQuestionnaireByIdPO) {

        //根据问卷id查询问卷详情
        QueryQuestionnaireByIdVO queryQuestionnaireByIdVO = questionnaireMapper.queryById(queryQuestionnaireByIdPO);

        //根据问卷id查询问题list
        List<QuestionVO> questionList = questionMapper.queryByQuestionnaireId(queryQuestionnaireByIdPO);

        for(QuestionVO vo : questionList){

            //根据问题id查询选项list
            List<OptionVO> optionList = optionMapper.queryByQuestionId(vo.getQuestionId());

            vo.setList(optionList);
        }
        queryQuestionnaireByIdVO.setList(questionList);

        return queryQuestionnaireByIdVO;
    }

    @Override
    public Boolean delete(DeleteQuestionnairePO deleteQuestionnairePO) {

        Map<String,Object> map = new HashMap<>();
        map.put("questionnaire_id",deleteQuestionnairePO.getQuestionnaireId());
        List<QQuestion> qQuestions = questionMapper.selectByMap(map);

        if(CollUtil.isNotEmpty(qQuestions)){
            List<String> questionIds = qQuestions.stream().map(QQuestion::getQuestionId).collect(Collectors.toList());
            if(questionMapper.deleteBatchIds(questionIds) <= 0){
                throw new RRException(ErrorCodeEnum.ERROR_DELETE);
            }
            List<String> optionIdList = new ArrayList<>();
            for(String id : questionIds){
                Map<String,Object> map1 = new HashMap<>();
                map1.put("question_id",id);
                List<QOption> qOptions = optionMapper.selectByMap(map1);
                if(CollUtil.isNotEmpty(qOptions)){
                    optionIdList.addAll(qOptions.stream().map(QOption::getOptionId).collect(Collectors.toList()));
                }
            }
            if(CollUtil.isNotEmpty(optionIdList)){
                if(optionMapper.deleteBatchIds(optionIdList) <= 0){
                    throw new RRException(ErrorCodeEnum.ERROR_DELETE);
                }
            }
        }

        return questionnaireMapper.deleteQuestionnaire(deleteQuestionnairePO) > 0;
    }

    @Override
    public Boolean generatedUrl(GeneratedUrlPO generatedUrlPO) {
        generatedUrlPO.setGenerateStatusCode(GenerateStatusEnum.GENERATED.getVal());
        generatedUrlPO.setUpdateTime(new Date());
        return questionnaireMapper.generatedUrl(generatedUrlPO) > 0;
    }

    @Override
    public Boolean writeQuestionnaire(List<WriteQuestionnairePO> writeQuestionnairePOList) {

        if(CollUtil.isEmpty(writeQuestionnairePOList)){
            throw new RRException(ErrorCodeEnum.ERROR_NULL_PARAM);
        }
        for(WriteQuestionnairePO po : writeQuestionnairePOList){
            po.setAnswerId(IdUtil.objectId());
            po.setCreateTime(new Date());
        }
        return answerMapper.add(writeQuestionnairePOList) > 0;
    }

    @Override
    public StatisticsQuestionnaireVO statistics(StatisticsQuestionnairePO statisticsQuestionnairePO) {
        //返回的vo
        StatisticsQuestionnaireVO statisticsQuestionnaireVO = new StatisticsQuestionnaireVO();

        //查询po
        QueryQuestionnaireByIdPO queryQuestionnaireByIdPO = new QueryQuestionnaireByIdPO();
        //添加po参数id
        queryQuestionnaireByIdPO.setQuestionnaireId(statisticsQuestionnairePO.getQuestionnaireId());
        //调用查询
        QueryQuestionnaireByIdVO queryQuestionnaireByIdVO = questionnaireService.queryById(queryQuestionnaireByIdPO);
        //添加返回id
        statisticsQuestionnaireVO.setQuestionnaireId(queryQuestionnaireByIdVO.getQuestionnaireId());
        //添加返回name
        statisticsQuestionnaireVO.setQuestionnaireName(queryQuestionnaireByIdVO.getQuestionnaireName());
        //获取查询问题数组
        List<QuestionVO> questionList = queryQuestionnaireByIdVO.getList();
        List<QAnswer> answerList = new ArrayList();
        //判空
        if(CollUtil.isNotEmpty(questionList)){
            //遍历问题数组
            for (QuestionVO questionVO : questionList){
                if(questionVO.getQuestionTypeCode().equals(QuestionTypeEnum.QUESTION_AND_ANSWERS.getVal())){
                    continue;
                }
                //获取选项list
                List<OptionVO> optionList = questionVO.getList();
                //判空
                if(CollUtil.isNotEmpty(optionList)){
                    //遍历选项list
                    for (OptionVO optionVO : optionList){
                        //根据选项id查询答案list
                        Map<String,Object> optionMap = new HashMap<>(1);
                        optionMap.put("option_id",optionVO.getOptionId());
                        answerList.addAll(answerMapper.selectByMap(optionMap));
                    }
                }
            }
        }
        if(CollUtil.isNotEmpty(answerList)){
            List<StatisticsQuestionVO> statisticsQuestionList = new ArrayList<>();
            for(QuestionVO questionVO : questionList){
                if(questionVO.getQuestionTypeCode().equals(QuestionTypeEnum.QUESTION_AND_ANSWERS.getVal())){
                    continue;
                }
                StatisticsQuestionVO statisticsQuestionVO = new StatisticsQuestionVO();
                statisticsQuestionVO.setQuestionId(questionVO.getQuestionId());
                statisticsQuestionVO.setQuestionTitle(questionVO.getQuestionTitle());
                List<OptionVO> optionList = questionVO.getList();
                List<StatisticsOptionVO> statisticsOptionList = new ArrayList<>();
                if(CollUtil.isNotEmpty(optionList)){
                    for(OptionVO optionVO : optionList){
                        StatisticsOptionVO statisticsOptionVO = new StatisticsOptionVO();
                        statisticsOptionVO.setOptionId(optionVO.getOptionId());
                        statisticsOptionVO.setOptionValue(optionVO.getOptionValue());
                        List<String> collect = answerList.stream().map(QAnswer::getOptionId).collect(Collectors.toList());
                        Integer count = 0;
                        for(String id : collect){
                            if(optionVO.getOptionId().equals(id)){
                                count++;
                            }
                        }
                        statisticsOptionVO.setAnswerCount(count);
                        statisticsOptionList.add(statisticsOptionVO);
                    }
                }
                statisticsQuestionVO.setList(statisticsOptionList);
                statisticsQuestionList.add(statisticsQuestionVO);
            }
            statisticsQuestionnaireVO.setList(statisticsQuestionList);
        }
        return statisticsQuestionnaireVO;
    }
}
