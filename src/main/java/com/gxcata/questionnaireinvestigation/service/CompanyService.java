package com.gxcata.questionnaireinvestigation.service;

import com.gxcata.questionnaireinvestigation.po.AddCompanyPO;
import com.gxcata.questionnaireinvestigation.po.CompanyPO;
import com.gxcata.questionnaireinvestigation.po.DeleteCompanyPO;
import com.gxcata.questionnaireinvestigation.po.UpdateCompanyPO;
import com.gxcata.questionnaireinvestigation.vo.CompanyVO;

import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:11
 */
public interface CompanyService {

    /**
     * 新增单位
     * @param addCompanyPO
     * @return
     */
    Boolean add(AddCompanyPO addCompanyPO);

    /**
     * 查询所有单位信息
     * @return
     */
    List<CompanyVO> queryCompany(CompanyPO companyPO);

    /**
     * 修改单位信息
     * @param updateCompanyPO
     * @return
     */
    Boolean updateCompany(UpdateCompanyPO updateCompanyPO);

    /**
     * 删除单位
     * @param deleteCompanyPO
     * @return
     */
    Boolean deleteCompany(DeleteCompanyPO deleteCompanyPO);
}
