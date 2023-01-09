package com.gxcata.questionnaireinvestigation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxcata.questionnaireinvestigation.entity.CCompany;
import com.gxcata.questionnaireinvestigation.po.AddCompanyPO;
import com.gxcata.questionnaireinvestigation.po.CompanyPO;
import com.gxcata.questionnaireinvestigation.po.DeleteCompanyPO;
import com.gxcata.questionnaireinvestigation.po.UpdateCompanyPO;
import com.gxcata.questionnaireinvestigation.vo.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:12
 */
@Mapper
public interface CompanyMapper extends BaseMapper<CCompany> {

    /**
     * 新增单位
     * @param addCompanyPO
     * @return
     */
    int add(AddCompanyPO addCompanyPO);

    /**
     * 查询所有单位信息
     * @param companyPO
     * @return
     */
    List<CompanyVO> queryCompany(CompanyPO companyPO);

    /**
     * 修改单位信息
     * @param updateCompanyPO
     * @return
     */
    int updateCompany(UpdateCompanyPO updateCompanyPO);

    /**
     * 删除单位信息
     * @param deleteCompanyPO
     * @return
     */
    int deleteCompany(DeleteCompanyPO deleteCompanyPO);
}
