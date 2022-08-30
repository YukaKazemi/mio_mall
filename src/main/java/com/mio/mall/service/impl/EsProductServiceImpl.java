package com.mio.mall.service.impl;

import com.mio.mall.dao.EsProductDao;
import com.mio.mall.elasticsearch.document.EsProduct;
import com.mio.mall.elasticsearch.repository.EsProductRepository;
import com.mio.mall.service.EsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 商品搜索管理Service实现类
 * @author: miosakura
 * @date: 2022-08-30 14:00
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;


    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable  = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result=0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;


    }

    /**
     * 根据id删除商品
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * 根据id创建商品
     *
     * @param id
     */
    @Override
    public EsProduct create(Long id) {
        EsProduct result =null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size()>0) {
            EsProduct esProduct=esProductList.get(0);
            result = productRepository.save(esProduct);

        }
        return result;
    }

    /**
     * 批量删除商品
     *
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            ArrayList<EsProduct> esProductList  = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }

    }

    /**
     * 根据关键字搜索名称或者副标题
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     */
    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword,pageable);
    }
}
