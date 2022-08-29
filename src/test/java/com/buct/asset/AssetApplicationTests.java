package com.buct.asset;

import com.buct.asset.model.AssetInfo;
import com.buct.asset.service.IAssetInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class AssetApplicationTests {

    @Autowired
    private IAssetInfoService assetInfoService;


    @Test
    void mock() {
        Random random = new Random();
        long offset = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        List<AssetInfo> saved = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            AssetInfo assetInfo = AssetInfo.builder()
                    .assetId(getLong(random))
                    .assetCategory("资产类别" + getLong(random))
                    .assetName("资产名称" + getLong(random))
                    .financeAssetId(getLong(random))
                    .amount(new BigDecimal(Math.abs(random.nextLong()) % 1000000))
                    .company("使用单位号" + getLong(random))
                    .depreciationCategory("折旧类别" + getLong(random))
                    .depreciationType("折旧方式" + getLong(random))
                    .fundsSubject("经费科目" + getLong(random))
                    .storeLocation("存放地名称" + getLong(random))
                    .useDirection("使用方向" + getLong(random))
                    .orderId(getLong(random))
                    .userId("使用人编号" + getLong(random))
                    .user("使用人" + getLong(random))
                    .financeEntryTime(new Timestamp(offset + (long) (Math.random() * diff)))
                    .financeEntryTimeCaiwu(new Timestamp(offset + (long) (Math.random() * diff)))
                    .build();
            saved.add(assetInfo);
        }
        assetInfoService.saveBatch(saved);
    }
    
    private Long getLong(Random random) {
        return Math.abs(random.nextLong() % 10000);
    }

}
