package com.gxcata.questionnaireinvestigation.service.impl;

import cn.hutool.core.util.IdUtil;
import com.gxcata.questionnaireinvestigation.mapper.CompanyMapper;
import com.gxcata.questionnaireinvestigation.po.AddCompanyPO;
import com.gxcata.questionnaireinvestigation.po.CompanyPO;
import com.gxcata.questionnaireinvestigation.po.DeleteCompanyPO;
import com.gxcata.questionnaireinvestigation.po.UpdateCompanyPO;
import com.gxcata.questionnaireinvestigation.service.CompanyService;
import com.gxcata.questionnaireinvestigation.vo.CompanyVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:12
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Boolean add(AddCompanyPO addCompanyPO) {
        addCompanyPO.setCompanyId(IdUtil.objectId());
        addCompanyPO.setCreateTime(new Date());
        return companyMapper.add(addCompanyPO) > 0;
    }

    @Override
    public List<CompanyVO> queryCompany(CompanyPO companyPO) {
        return companyMapper.queryCompany(companyPO);
    }

    @Override
    public Boolean updateCompany(UpdateCompanyPO updateCompanyPO) {
        updateCompanyPO.setUpdateTime(new Date());
        return companyMapper.updateCompany(updateCompanyPO) > 0;
    }

    @Override
    public Boolean deleteCompany(DeleteCompanyPO deleteCompanyPO) {
        return companyMapper.deleteCompany(deleteCompanyPO) > 0;
    }
}
