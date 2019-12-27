package com.gexiiiii.gfood.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:19
 * description :
 */
@Entity(nameInDb = "t_look_history")
public class LookHistoryBean {
    /**
     * 菜谱ID
     */
    @Id
    private String id;
    /**
     * 菜谱名
     */
    private String title;
    /**
     * 菜谱标签
     */
    private String tags;
    /**
     * 菜谱介绍
     */
    private String imtro;
    /**
     * 菜谱材料
     */
    private String ingredients;
    /**
     * 菜谱调料
     */
    private String burden;
    /**
     * 菜谱图
     */
    private String albums;
    private long date;
    @Generated(hash = 648578601)
    public LookHistoryBean(String id, String title, String tags, String imtro,
            String ingredients, String burden, String albums, long date) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.imtro = imtro;
        this.ingredients = ingredients;
        this.burden = burden;
        this.albums = albums;
        this.date = date;
    }
    @Generated(hash = 611283828)
    public LookHistoryBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTags() {
        return this.tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getImtro() {
        return this.imtro;
    }
    public void setImtro(String imtro) {
        this.imtro = imtro;
    }
    public String getIngredients() {
        return this.ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getBurden() {
        return this.burden;
    }
    public void setBurden(String burden) {
        this.burden = burden;
    }
    public String getAlbums() {
        return this.albums;
    }
    public void setAlbums(String albums) {
        this.albums = albums;
    }
    public long getDate() {
        return this.date;
    }
    public void setDate(long date) {
        this.date = date;
    }
}
