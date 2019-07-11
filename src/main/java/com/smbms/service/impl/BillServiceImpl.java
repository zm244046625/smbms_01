package com.smbms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.pojo.Bill;
import com.smbms.pojo.BillExample;
import com.smbms.repository.BillMapper;
import com.smbms.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper mapper;

    @Override
    public List<Bill> findBillByPage(int pageNum, int pageSize) {
        // 必须写在第一行开发分页的拦截功能
        PageHelper.startPage(pageNum,pageSize);
        BillExample billExample = new BillExample();
        billExample.setOrderByClause("creationDate desc");
        List<Bill> bills = mapper.selectByExample(billExample);
        PageInfo<Bill> pageInfo = new PageInfo<>(bills);
        List<Bill> list = pageInfo.getList();
        return list;
    }

    @Override
    public PageInfo<Bill> findBillPage(int pageNum, int pageSize) {
        // 必须写在第一行开发分页的拦截功能
        PageHelper.startPage(pageNum,pageSize);
        BillExample billExample = new BillExample();
        billExample.setOrderByClause("creationDate desc");
        List<Bill> bills = mapper.selectByExample(billExample);
        PageInfo<Bill> pageInfo = new PageInfo<>(bills);
        return pageInfo;
    }

    @Override
    public Bill findBillByBillCode(String billCode) {
        BillExample example = new BillExample();
        BillExample.Criteria criteria = example.createCriteria();
        criteria.andBillCodeEqualTo(billCode);
        List<Bill> bills = mapper.selectByExample(example);
        if (bills.size()>0){
            return bills.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<Bill> findBillPage(int pageNum, int pageSize, Date begin, Date end) {
        PageHelper.startPage(pageNum,pageSize);
        BillExample example = new BillExample();
        BillExample.Criteria criteria = example.createCriteria();
        criteria.andCreationDateBetween(begin,end);
        List<Bill> bills = mapper.selectByExample(example);
        PageInfo<Bill> pageInfo = new PageInfo<>(bills);
        return pageInfo;
    }
}
