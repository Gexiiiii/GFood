package com.gexiiiii.gfood.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:33
 * description :
 */
@Entity(nameInDb = "tb_favorite_menu")
public class FavoriteMenuBean {
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

    @Generated(hash = 1252165506)
    public FavoriteMenuBean(String id, String title, String tags, String imtro,
                            String ingredients, String burden, String albums) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.imtro = imtro;
        this.ingredients = ingredients;
        this.burden = burden;
        this.albums = albums;
    }

    @Generated(hash = 226594610)
    public FavoriteMenuBean() {
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
}
