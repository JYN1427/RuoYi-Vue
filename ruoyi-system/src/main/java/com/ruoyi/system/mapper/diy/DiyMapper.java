package com.ruoyi.system.mapper.diy;

import com.ruoyi.common.core.domain.entity.DiyStaticsData;

import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 21:54:46
 * @Version: 1.0.0
 */
public interface DiyMapper {

    /**
     * 查询单行数据
     *
     * @param staticsId
     * @return
     */
    DiyStaticsData selectById(Long staticsId);

    /**
     * 列表查询
     *
     * @param diyStaticsData
     * @return
     */
    List<DiyStaticsData> selectDiyStaticsData(DiyStaticsData diyStaticsData);

    /**
     * 新增每日数据
     *
     * @param diyStaticsData
     * @return
     */
    int insert(DiyStaticsData diyStaticsData);

    /**
     * 修改每日数据
     *
     * @param diyStaticsData
     * @return
     */
    int update(DiyStaticsData diyStaticsData);

    /**
     * 批量删除
     *
     * @param staticsIds
     */
    void deleteByIds(Long[] staticsIds);
}
