package com.gexiiiii.gfood.bean;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/11 10:40
 * description :
 */
public class DateBean<T> {
    private String date;
    private List<T> list;

    public DateBean() {
    }

    public DateBean(String date, List<T> list) {
        this.date = date;
        this.list = list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
