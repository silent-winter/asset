package com.buct.asset.controller;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buct.asset.model.AssetInfo;
import com.buct.asset.service.IAssetInfoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yudongzei
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/assetInfo")
public class AssetInfoController {

    @Autowired
    private IAssetInfoService assetInfoService;


    @PostMapping("/page")
    public Page<AssetInfo> findPage(@RequestBody QueryRequest request) {
        QueryWrapper<AssetInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(request.getCompany())) {
            queryWrapper.like("company", request.getCompany());
        }
        if (StringUtils.isNotBlank(request.getAssetId())) {
            String[] split = request.getAssetId().split("_");
            if (StringUtils.isNotBlank(split[0])) {
                queryWrapper.ge("asset_id", split[0]);
            }
            if (split.length > 1 && StringUtils.isNotBlank(split[1])) {
                queryWrapper.le("asset_id", split[1]);
            }
        }
        if (StringUtils.isNotBlank(request.getAssetName())) {
            queryWrapper.like("asset_name", request.getAssetName());
        }
        if (StringUtils.isNotBlank(request.getFinanceAssetId()) || StringUtils.isNumeric(request.getFinanceAssetId())) {
            queryWrapper.eq("finance_asset_id", Long.valueOf(request.getFinanceAssetId()));
        }
        if (StringUtils.isNotBlank(request.getFinanceEntryTime())) {
            String[] split = request.getFinanceEntryTime().split("_");
            if (StringUtils.isNotBlank(split[0])) {
                queryWrapper.ge("finance_entry_time", split[0]);
            }
            if (split.length > 1 && StringUtils.isNotBlank(split[1])) {
                queryWrapper.le("finance_entry_time", split[1]);
            }
        }
        if (StringUtils.isNotBlank(request.getFinanceEntryTimeCaiwu())) {
            String[] split = request.getFinanceEntryTimeCaiwu().split("_");
            if (StringUtils.isNotBlank(split[0])) {
                queryWrapper.ge("finance_entry_time_caiwu", split[0]);
            }
            if (split.length > 1 && StringUtils.isNotBlank(split[1])) {
                queryWrapper.le("finance_entry_time_caiwu", split[1]);
            }
        }
        if (StringUtils.isNotBlank(request.getAssetCategory())) {
            queryWrapper.like("asset_category", request.getAssetCategory());
        }
        if (StringUtils.isNotBlank(request.getDepreciationCategory())) {
            queryWrapper.like("depreciation_category", request.getDepreciationCategory());
        }
        if (StringUtils.isNotBlank(request.getDepreciationType())) {
            queryWrapper.like("depreciation_type", request.getDepreciationType());
        }
        if (StringUtils.isNotBlank(request.getOrderId())) {
            String[] split = request.getOrderId().split("_");
            if (StringUtils.isNotBlank(split[0])) {
                queryWrapper.ge("order_id", split[0]);
            }
            if (split.length > 1 && StringUtils.isNotBlank(split[1])) {
                queryWrapper.le("order_id", split[1]);
            }
        }
        if (StringUtils.isNotBlank(request.getUser())) {
            queryWrapper.like("user", request.getUser());
        }
        if (StringUtils.isNotBlank(request.getUserId())) {
            queryWrapper.like("user_id", request.getUserId());
        }
        if (StringUtils.isNotBlank(request.getStoreLocation())) {
            queryWrapper.like("store_location", request.getStoreLocation());
        }
        if (StringUtils.isNotBlank(request.getAmount())) {
            String[] split = request.getAmount().split("_");
            if (StringUtils.isNotBlank(split[0])) {
                queryWrapper.ge("amount", split[0]);
            }
            if (split.length > 1 && StringUtils.isNotBlank(split[1])) {
                queryWrapper.le("amount", split[1]);
            }
        }
        if (StringUtils.isNotBlank(request.getFundsSubject())) {
            queryWrapper.like("funds_subject", request.getFundsSubject());
        }
        if (StringUtils.isNotBlank(request.getUseDirection())) {
            queryWrapper.like("use_direction", request.getUseDirection());
        }
        return assetInfoService.page(
                new Page<>(request.getPage(), request.getSize()), queryWrapper
        );
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class QueryRequest {
        private int page;
        private int size;
        // 使用单位
        private String company;
        // 资产编号(1_100)
        private String assetId;
        // 资产名称
        private String assetName;
        // 财政资产号
        private String financeAssetId;
        // 财政入账日期(2019-12-01_2099-01-01)
        private String financeEntryTime;
        // 财务入账日期(2019-12-01_2099-01-01)
        private String financeEntryTimeCaiwu;
        // 资产类别
        private String assetCategory;
        // 折旧类别
        private String depreciationCategory;
        // 折旧方式
        private String depreciationType;
        // 单据号
        private String orderId;
        // 使用人
        private String user;
        // 使用人编号
        private String userId;
        // 存放地名称
        private String storeLocation;
        // 金额(10000_20000)
        private String amount;
        // 经费科目
        private String fundsSubject;
        // 使用方向
        private String useDirection;
    }

}
