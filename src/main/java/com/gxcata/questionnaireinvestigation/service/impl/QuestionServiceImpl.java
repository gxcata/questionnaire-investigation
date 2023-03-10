package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.common.enums.StatusCodeEnum;
import com.gxcata.questionnaireinvestigation.common.exception.RRException;
import com.gxcata.questionnaireinvestigation.common.utils.StringUtils;
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
            if(StringUtils.isEmpty(addOptionPO.getOptionId())){
                addOptionPO.setOptionId(IdUtil.objectId());
            }
            addOptionPO.setQuestionId(updateQuestionPO.getQuestionId());
            addOptionPO.setStatusCode(StatusCodeEnum.ENABLE.getVal());
            addOptionList.add(addOptionPO);
        }

        if(optionMapper.add(addOptionList) <= 0){
            throw new RRException(ErrorCodeEnum.ERROR_ADD);
        }

        return questionMapper.updateQuestion(updateQuestionPO) > 0;
    }

    @Override
    public Boolean add(AddQuestionPO addQuestionPO) {
        String id = IdUtil.objectId();
        addQuestionPO.setQuestionId(id);
        addQuestionPO.setStatusCode(StatusCodeEnum.ENABLE.getVal());
        List<AddQuestionPO> list = new ArrayList<>(1);
        list.add(addQuestionPO);
        List<AddOptionPO> addOptionList = addQuestionPO.getList();
        for(AddOptionPO po :addOptionList){
            po.setStatusCode(StatusCodeEnum.ENABLE.getVal());
            po.setQuestionId(id);
            po.setOptionId(IdUtil.objectId());
        }
        if(optionMapper.add(addOptionList) <= 0){
            throw new RRException(ErrorCodeEnum.ERROR_ADD);
        }


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
