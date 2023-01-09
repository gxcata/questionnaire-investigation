package com.gxcata.questionnaireinvestigation.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.QQuestion;
import com.gxcata.questionnaireinvestigation.po.AddQuestionPO;
import com.gxcata.questionnaireinvestigation.po.QueryQuestionnaireByIdPO;
import com.gxcata.questionnaireinvestigation.po.UpdateQuestionPO;
import com.gxcata.questionnaireinvestigation.vo.QuestionVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:59
 */
@Mapper
public interface QuestionMapper extends BaseMapper<QQuestion> {
    /**
     * 批量新增问题
     * @param list
     * @return
     */
    int add(List<AddQuestionPO> list);

    /**
     * 修改问题
     * @param questionPO
     * @return
     */
    int updateQuestion(UpdateQuestionPO questionPO);

    /**
     * 根据问卷id查询问题列表
     * @param queryQuestionnaireByIdPO
     * @return
     */
    List<QuestionVO> queryByQuestionnaireId(QueryQuestionnaireByIdPO queryQuestionnaireByIdPO);
}
