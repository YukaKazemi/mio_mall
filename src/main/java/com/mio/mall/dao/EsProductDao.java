package com.mio.mall.dao;

import com.mio.mall.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 搜索系统中的商品管理自定义Dao
 * @author: miosakura
 * @date: 2022-08-30 14:02
 */
@Repository
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
