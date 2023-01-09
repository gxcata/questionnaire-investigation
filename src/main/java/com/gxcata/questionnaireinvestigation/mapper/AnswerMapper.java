package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.QAnswer;
import com.gxcata.questionnaireinvestigation.po.QueryAnswerCountPO;
import com.gxcata.questionnaireinvestigation.po.WriteQuestionnairePO;
import com.gxcata.questionnaireinvestigation.vo.StatisticsAnswerVO;
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

    /**
     * 根据选项id统计答案个数
     * @param queryAnswerCountPO
     * @return
     */
    List<StatisticsAnswerVO> queryAnswerCount(QueryAnswerCountPO queryAnswerCountPO);
}
