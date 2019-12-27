package com.gexiiiii.gfood.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:26
 * description :
 */
@Entity(nameInDb = "tb_note")
public class NoteBean {
    /**
     * 菜谱ID
     */
    @Id
    private String menuId;
    /**
     * 笔记标题
     */
    private String title;
    /**
     * 笔记内容
     */
    private String content;
    /**
     * 笔记时间
     */
    private long time;

    @Generated(hash = 154151467)
    public NoteBean(String menuId, String title, String content, long time) {
        this.menuId = menuId;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    @Generated(hash = 451626881)
    public NoteBean() {
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
