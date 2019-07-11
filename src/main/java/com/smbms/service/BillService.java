package com.smbms.service;

import com.github.pagehelper.PageInfo;
import com.smbms.pojo.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {

    /**
     * 查询所有订单 分页
     * @param pageNum 当前页码
     * @param pageSize 页面容量
     * @return List<Bill>
     */
    List<Bill> findBillByPage(int pageNum,int pageSize);

    /**
     * 查询所有订单 分页
     * @param pageNum 当前页码
     * @param pageSize 页面容量
     * @return PageInfo<Bill>
     */
    PageInfo<Bill> findBillPage (int pageNum,int pageSize);

    /**
     * 根据订单号获取订单
     * @param billCode
     * @return
     */
    Bill findBillByBillCode(String billCode);

    /**
     * 获取指定日期范围内的订单数据 带分页
     * @param pageNum
     * @param pageSize
     * @param begin
     * @param end
     * @return
     */
    PageInfo<Bill> findBillPage (int pageNum, int pageSize, Date begin,Date end);

}
