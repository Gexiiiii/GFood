package com.gexiiiii.gfood.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:33
 * description :
 */
@Entity(nameInDb = "tb_favorite_news")
public class FavoriteNewsBean {
    /**
     * 新闻唯一值
     */
    @Id
    private String uniquekey;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 新闻时间
     */
    private String date;
    /**
     * 新闻作者
     */
    private String author;
    /**
     * 新闻详细页地址
     */
    private String url;
    /**
     * 新闻图
     */
    private String pic;

    @Generated(hash = 352543488)
    public FavoriteNewsBean(String uniquekey, String title, String date,
                            String author, String url, String pic) {
        this.uniquekey = uniquekey;
        this.title = title;
        this.date = date;
        this.author = author;
        this.url = url;
        this.pic = pic;
    }

    @Generated(hash = 351615996)
    public FavoriteNewsBean() {
    }

    public String getUniquekey() {
        return this.uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
