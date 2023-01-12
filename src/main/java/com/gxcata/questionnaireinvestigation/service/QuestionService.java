package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.po.AddQuestionPO;
import com.gxcata.questionnaireinvestigation.po.DeleteQuestionPO;
import com.gxcata.questionnaireinvestigation.po.UpdateQuestionPO;

/**
 * @author wanghailun
 * @date 2023年01月12日 9:47
 */
public interface QuestionService {

    /**
     * 根据单位id查询单位信息
     * @param updateQuestionPO
     * @return
     */
    Boolean updateQuestion(UpdateQuestionPO updateQuestionPO);

    /**
     * 新增问题
     * @param addQuestionPO
     * @return
     */
    Boolean add(AddQuestionPO addQuestionPO);

    /**
     * 删除问题
     * @param deleteQuestionPO
     * @return
     */
    Boolean delete(DeleteQuestionPO deleteQuestionPO);
}
