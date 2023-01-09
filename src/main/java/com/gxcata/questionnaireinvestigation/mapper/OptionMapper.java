package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.QOption;
import com.gxcata.questionnaireinvestigation.po.AddOptionPO;
import com.gxcata.questionnaireinvestigation.po.UpdateOptionPO;
import com.gxcata.questionnaireinvestigation.vo.OptionVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月03日 9:38
 */
@Mapper
public interface OptionMapper extends BaseMapper<QOption> {

    /**
     * 批量添加答案选项
     * @param optionList
     * @return
     */
    int add(List<AddOptionPO> optionList);

    /**
     * 修改答案选项
     * @param optionPO
     * @return
     */
    int updateOption(UpdateOptionPO optionPO);

    /**
     * 根据问题id查询选项
     * @param questionId
     * @return
     */
    List<OptionVO> queryByQuestionId(String questionId);
}
