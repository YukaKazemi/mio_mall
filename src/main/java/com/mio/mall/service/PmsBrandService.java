package com.mio.mall.service;

import com.mio.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description:
 * @author: miosakura
 * @date: 2022-08-22 16:23
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
