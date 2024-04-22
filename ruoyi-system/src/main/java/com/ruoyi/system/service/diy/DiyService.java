package com.ruoyi.system.service.diy;

import com.ruoyi.common.core.domain.entity.DiyStaticsData;

import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 21:51:27
 * @Version: 1.0.0
 */
public interface DiyService {

    DiyStaticsData selectDiyStaticsDataById(Long staticsId);

    List<DiyStaticsData> selectDiyStaticsData(DiyStaticsData diyStaticsData);

    /**
     * 新增每日数据
     *
     * @param diyStaticsData
     * @return
     */
    int insertDiyStaticsData(DiyStaticsData diyStaticsData);

    int updateDiyStaticsData(DiyStaticsData diyStaticsData);

    /**
     * 删除身体数据 (传数组, 支持批量)
     * @param staticsIds
     */
    void deleteDiyStaticsData(Long[] staticsIds);
}
