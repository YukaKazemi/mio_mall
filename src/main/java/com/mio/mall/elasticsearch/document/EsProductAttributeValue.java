package com.mio.mall.elasticsearch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @description:搜索中的商品属性信息
 * @author: miosakura
 * @date: 2022-08-30 13:55
 */
@Setter
@Getter
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = -4942464472055085995L;
    private Long id;
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    //属性参数：0->规格；1->参数
    private Integer type;
    //属性名称
    @Field(type=FieldType.Keyword)
    private String name;
}
