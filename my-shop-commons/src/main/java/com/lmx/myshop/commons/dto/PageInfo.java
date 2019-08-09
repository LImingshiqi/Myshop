package com.lmx.myshop.commons.dto;


import com.lmx.myshop.commons.persitence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据传输对象
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recodsTotal;
    private int recodsFiltered;
    private List<T> data;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getRecodsFiltered() {
        return recodsFiltered;
    }

    public void setRecodsFiltered(int recodsFiltered) {
        this.recodsFiltered = recodsFiltered;
    }

    public int getRecodsTotal() {
        return recodsTotal;
    }

    public void setRecodsTotal(int recodsTotal) {
        this.recodsTotal = recodsTotal;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
