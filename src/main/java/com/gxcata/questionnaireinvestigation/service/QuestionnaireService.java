package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.po.*;
import com.gxcata.questionnaireinvestigation.vo.QueryQuestionnaireByIdVO;
import com.gxcata.questionnaireinvestigation.vo.QuestionnaireVO;
import com.gxcata.questionnaireinvestigation.vo.StatisticsQuestionnaireVO;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月31日 9:58
 */
public interface QuestionnaireService {

    /**
     * 新增问卷
     * @param addQuestionnairePO
     * @return
     */
    Boolean add(AddQuestionnairePO addQuestionnairePO);

    /**
     * 查询问卷
     * @param questionnairePO
     * @return
     */
    List<QuestionnaireVO> query(QuestionnairePO questionnairePO);

    /**
     * 修改问卷
     * @param updateQuestionnairePO
     * @return
     */
    boolean update(UpdateQuestionnairePO updateQuestionnairePO);

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
    Boolean delete(DeleteQuestionnairePO deleteQuestionnairePO);

    /**
     * 生成连接
     * @param generatedUrlPO
     * @return
     */
    Boolean generatedUrl(GeneratedUrlPO generatedUrlPO);

    /**
     * 填写问卷
     * @param writeQuestionnairePOList
     * @return
     */
    Boolean writeQuestionnaire(List<WriteQuestionnairePO> writeQuestionnairePOList);

    /**
     * 问卷统计
     * @param statisticsQuestionnairePO
     * @return
     */
    StatisticsQuestionnaireVO statistics(StatisticsQuestionnairePO statisticsQuestionnairePO);
}
