package com.ruoyi.web.controller.diy;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictType;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.entity.DiyStaticsData;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.service.diy.DiyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 21:31:44
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/diy/statics")
public class DiyController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(DiyController.class);

    @Autowired
    private DiyService diyService;

    /**
     * 查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:statics:query')")
    @GetMapping(value = "/{staticsId}")
    public AjaxResult getInfo(@PathVariable("staticsId") Long staticsId) {
        return success(diyService.selectDiyStaticsDataById(staticsId));
    }

    @PreAuthorize("@ss.hasPermi('system:statics:list')")
    @GetMapping("/list")
    public TableDataInfo list(DiyStaticsData diyStaticsData, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            TableDataInfo tableDataInfo = new TableDataInfo();
            tableDataInfo.setCode(HttpStatus.ERROR);
            tableDataInfo.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return tableDataInfo;
        }
        startPage();
        List<DiyStaticsData> list = diyService.selectDiyStaticsData(diyStaticsData);
        return getDataTable(list);
    }

    /**
     * 通用上传请求（单个）
     */
    @PreAuthorize("@ss.hasPermi('system:statics:add')")
    @Log(title = "身体数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult insertDailyStatics(@Valid @RequestBody DiyStaticsData diyStaticsData, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            return AjaxResult.error(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = getUsername();
        diyStaticsData.setCreateBy(username)
                .setUpdateBy(username);
        int i = diyService.insertDiyStaticsData(diyStaticsData);
        return toAjax(i);
    }

    /**
     * 修改身体数据
     */
    @PreAuthorize("@ss.hasPermi('system:statics:edit')")
    @Log(title = "身体数据", businessType = BusinessType.UPDATE)
    @PutMapping("/update")
    public AjaxResult edit(@Valid @RequestBody DiyStaticsData diyStaticsData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResult.error(bindingResult.getFieldError().getDefaultMessage());
        }
        diyStaticsData.setUpdateBy(getUsername());
        int row = diyService.updateDiyStaticsData(diyStaticsData);
        return toAjax(row);
    }

    /**
     * 删除
     * @param staticsIds
     * @return
     * @throws ServiceException
     */
    @PreAuthorize("@ss.hasPermi('system:statics:remove')")
    @Log(title = "身体数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/delete/{staticsIds}")
    public AjaxResult delete(@PathVariable("staticsIds") Long[] staticsIds) throws ServiceException
    {
        diyService.deleteDiyStaticsData(staticsIds);
        return success();
    }

}
