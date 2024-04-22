package com.ruoyi.system.service.diy.impl;

import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.core.domain.entity.DiyStaticsData;
import com.ruoyi.system.mapper.diy.DiyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 22:29:49
 * @Version: 1.0.0
 */
@SpringBootTest
public class DiyServiceImplTest {

    @Value("${ruoyi.name}")
    private String name;

    @Autowired
    private DiyMapper diyMapper;

    @Test
    public void insertDataTest() {
        DiyStaticsData diyStaticsData = new DiyStaticsData();
        diyStaticsData.setDataDate(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd"));
        diyStaticsData.setPersonName("贾雨宁");
        diyStaticsData.setBloodPressureLow(new BigDecimal("70.55"));
        diyStaticsData.setBloodPressureHigh(new BigDecimal("70.55"));
        diyStaticsData.setWeight(new BigDecimal("71.11"));
        diyStaticsData.setCreateBy("jiayn01");
        int insert = diyMapper.insert(diyStaticsData);
        System.out.println(insert);
    }

}