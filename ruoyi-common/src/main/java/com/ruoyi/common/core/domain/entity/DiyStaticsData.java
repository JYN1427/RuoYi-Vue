package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/15 21:42:39
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class DiyStaticsData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String staticsId;

    @NotNull(message = "日期不可为空")
    private Date dataDate;

    @NotBlank(message = "当前人姓名不可为空")
    private String personName;

    @NotNull(message = "血压记录不可为空")
    private BigDecimal bloodPressureLow;

    @NotNull(message = "血压记录不可为空")
    private BigDecimal bloodPressureHigh;

    @NotNull(message = "体重不可为空")
    private BigDecimal weight;

    private String status;
}
