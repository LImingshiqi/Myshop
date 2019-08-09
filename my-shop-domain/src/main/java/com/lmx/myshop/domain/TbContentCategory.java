package com.lmx.myshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.commons.persitence.BaserTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2019/7/19 19:41
 */
@Data
public class TbContentCategory extends BaserTreeEntity {
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private  Boolean isParent;

    private TbContentCategory parent;


}
