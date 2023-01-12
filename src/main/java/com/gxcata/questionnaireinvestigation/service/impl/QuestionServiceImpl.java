package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum;
import com.gxcata.questionnaireinvestigation.mapper.OptionMapper;
import com.gxcata.questionnaireinvestigation.mapper.QuestionMapper;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghailun
 * @date 2023年01月12日 9:48
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private OptionMapper optionMapper;

    @Override
    public Boolean updateQuestion(UpdateQuestionPO updateQuestionPO) {
        Map<String,Object> map = new HashMap<>();
        map.put("question_id",updateQuestionPO.getQuestionId());
        if(optionMapper.deleteByMap(map) <= 0){
            throw new RRException(ErrorCodeEnum.ERROR_DELETE);
        }

        List<UpdateOptionPO> updateOptionList = updateQuestionPO.getList();
        List<AddOptionPO> addOptionList = new ArrayList<>();
        for(UpdateOptionPO updateOptionPO : updateOptionList){
            AddOptionPO addOptionPO = new AddOptionPO();
            BeanUtil.copyProperties(updateOptionPO,addOptionPO);
            addOptionList.add(addOptionPO);
        }

        if(optionMapper.add(addOptionList) <= 0){
            throw new RRException(ErrorCodeEnum.ERROR_ADD);
        }

        return questionMapper.updateQuestion(updateQuestionPO) > 0;
    }

    @Override
    public Boolean add(AddQuestionPO addQuestionPO) {
        List<AddQuestionPO> list = new ArrayList<>();
        list.add(addQuestionPO);
        return questionMapper.add(list) > 0;
    }

    @Override
    public Boolean delete(DeleteQuestionPO deleteQuestionPO) {
        Map<String,Object> map = new HashMap<>();
        map.put("question_id",deleteQuestionPO.getQuestionId());
        if(optionMapper.deleteByMap(map) <= 0){
            throw new RRException(ErrorCodeEnum.ERROR_DELETE);
        }
        return questionMapper.deleteQuestion(deleteQuestionPO) > 0;
    }
}
