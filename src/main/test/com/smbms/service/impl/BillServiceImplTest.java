package com.smbms.service.impl;

import com.github.pagehelper.PageInfo;
import com.smbms.pojo.Bill;
import com.smbms.service.BillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class BillServiceImplTest {
    // 写多个配置文件的格式：{"配置文件1","配置文件2"}
    @Autowired
    private BillService billService;

    @Test
    public void findBillByPage() {
        List<Bill> billByPage = billService.findBillByPage(1, 6);
        for (Bill bill :
                billByPage) {
            System.out.println(bill);
        }
    }

    @Test
    public void findBillPage() {
        PageInfo<Bill> billPage = billService.findBillPage(1, 6);
        System.out.println("数据数量：" + billPage.getList().size());
        System.out.println("pages:" + billPage.getPages());
        System.out.println("end row:" + billPage.getEndRow());
        System.out.println("nextPage:" + billPage.getNextPage());
        System.out.println("prePage:" + billPage.getPrePage());
    }

    @Test
    public void findBillByBillCode() {
        Bill bill = billService.findBillByBillCode("BILL2016_013");
        System.out.println(bill);
    }

    @Test
    public void findBillPage1() throws Exception{
        Date begin = new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-14");
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2016-04-14");
        PageInfo<Bill> billPage = billService.findBillPage(1, 6, end, begin);
        for (Bill bill :
                billPage.getList()) {
            System.out.println(bill);
        }
    }
}