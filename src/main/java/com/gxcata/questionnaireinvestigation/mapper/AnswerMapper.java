package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.QAnswer;
import com.gxcata.questionnaireinvestigation.po.WriteQuestionnairePO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月04日 15:10
 */
@Mapper
public interface AnswerMapper extends BaseMapper<QAnswer> {

    /**
     * 填写问卷
     * @param list
     * @return
     */
    int add(List<WriteQuestionnairePO> list);
}
