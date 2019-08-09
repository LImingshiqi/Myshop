package com.lmx.myshop.commons.persitence;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LMX on 2019/7/28 0:50
 */
@Data
public class BaserTreeEntity<T extends BaseEntity>extends BaseEntity implements Serializable {

    private T parent;
    private Boolean isParent;


}
