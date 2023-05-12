package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.QQuestionnaire;
import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.vo.QueryQuestionnaireByIdVO;
import com.gxcata.questionnaireinvestigation.vo.QuestionnaireVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:00
 */
@Mapper
public interface QuestionnaireMapper extends BaseMapper<QQuestionnaire> {
    /**
     * 新增问卷
     * @param addQuestionnairePO
     * @return
     */
    int add(AddQuestionnairePO addQuestionnairePO);

    /**
     * 查询问卷
     * @param questionnairePO
     * @return
     */
    List<QuestionnaireVO> query(QuestionnairePO questionnairePO);

    /**
     * 修改问卷信息
     * @param updateQuestionnairePO
     * @return
     */
    int updateQuestionnaire(UpdateQuestionnairePO updateQuestionnairePO);

    /**
     * 根据id查看问卷详情
     * @param queryQuestionnaireByIdPO
     * @return
     */
    QueryQuestionnaireByIdVO queryById(QueryQuestionnaireByIdPO queryQuestionnaireByIdPO);

    /**
     * 删除问卷
     * @param deleteQuestionnairePO
     * @return
     */
    int deleteQuestionnaire(DeleteQuestionnairePO deleteQuestionnairePO);

    /**
     * 生成链接
     * @param generatedUrlPO
     * @return
     */
    int generatedUrl(GeneratedUrlPO generatedUrlPO);
}
