package com.ruoyi.system.service.diy.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.core.domain.entity.DiyStaticsData;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.mapper.diy.DiyMapper;
import com.ruoyi.system.service.diy.DiyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 21:51:42
 * @Version: 1.0.0
 */
@Service
public class DiyServiceImpl implements DiyService {
    private static final Logger log = LoggerFactory.getLogger(DiyServiceImpl.class);

    @Autowired
    private DiyMapper diyMapper;

    @Override
    public DiyStaticsData selectDiyStaticsDataById(Long staticsId) {
        return diyMapper.selectById(staticsId);
    }

    @Override
    public List<DiyStaticsData> selectDiyStaticsData(DiyStaticsData diyStaticsData) {
        return diyMapper.selectDiyStaticsData(diyStaticsData);
    }

    @Override
    public int insertDiyStaticsData(DiyStaticsData diyStaticsData) {
        DateTime now = DateUtil.date();
        diyStaticsData.setCreateTime(now)
                .setUpdateTime(now);
        int insert = diyMapper.insert(diyStaticsData);
        log.info("成功插入staticsId={}的身体健康记录", diyStaticsData.getStaticsId()+"");
        return insert;
    }

    @Override
    public int updateDiyStaticsData(DiyStaticsData diyStaticsData) {
        int update = diyMapper.update(diyStaticsData);
        log.info("成功修改staticsId={}的身体健康记录", diyStaticsData.getStaticsId()+"");
        return update;
    }

    @Override
    public void deleteDiyStaticsData(Long[] staticsIds) throws ServiceException {
        if (staticsIds.length == 0) {
            log.error("未传输任何待删除id");
            throw new ServiceException("未传输任何待删除id");
        }
        diyMapper.deleteByIds(staticsIds);
        log.info("成功删除staticsIds={}的身体健康记录", Arrays.toString(staticsIds));
    }
}
