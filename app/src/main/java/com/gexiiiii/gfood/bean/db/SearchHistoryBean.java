package com.gexiiiii.gfood.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : Gexiiiii
 * date : 2019/12/11 15:41
 * description :
 */
@Entity(nameInDb = "t_search_history")
public class SearchHistoryBean {
    @Id
    private String keyword;
    private long date;
    @Generated(hash = 1055189632)
    public SearchHistoryBean(String keyword, long date) {
        this.keyword = keyword;
        this.date = date;
    }
    @Generated(hash = 1570282321)
    public SearchHistoryBean() {
    }
    public String getKeyword() {
        return this.keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public long getDate() {
        return this.date;
    }
    public void setDate(long date) {
        this.date = date;
    }
}
