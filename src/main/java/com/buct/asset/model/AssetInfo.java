package com.buct.asset.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yudongzei
 * @since 2022-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("asset_info")
@Builder
public class AssetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 使用单位
     */
    @TableField("company")
    private String company;

    /**
     * 资产编号
     */
    @TableField("asset_id")
    private Long assetId;

    /**
     * 资产名称
     */
    @TableField("asset_name")
    private String assetName;

    /**
     * 财政资产编号
     */
    @TableField("finance_asset_id")
    private Long financeAssetId;

    /**
     * 财政入账日期
     */
    @TableField("finance_entry_time")
    private Date financeEntryTime;

    /**
     * 财务入账日期
     */
    @TableField("finance_entry_time_caiwu")
    private Date financeEntryTimeCaiwu;

    /**
     * 资产类别
     */
    @TableField("asset_category")
    private String assetCategory;

    /**
     * 折旧类别
     */
    @TableField("depreciation_category")
    private String depreciationCategory;

    /**
     * 折旧方式
     */
    @TableField("depreciation_type")
    private String depreciationType;

    /**
     * 单据号
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 使用人
     */
    @TableField("user")
    private String user;

    /**
     * 使用人编号
     */
    @TableField("user_id")
    private String userId;

    /**
     * 存放地
     */
    @TableField("store_location")
    private String storeLocation;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 经费科目
     */
    @TableField("funds_subject")
    private String fundsSubject;

    /**
     * 使用方向
     */
    @TableField("use_direction")
    private String useDirection;


}
