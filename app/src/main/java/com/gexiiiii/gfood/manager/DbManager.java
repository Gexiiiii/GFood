package com.gexiiiii.gfood.manager;

import android.content.Context;

import com.gexiiiii.gfood.greendao.DaoMaster;
import com.gexiiiii.gfood.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:22
 * description :
 */
public class DbManager {

    private DaoSession daoSession;

    private DbManager() {
    }

    public static DbManager getInstance() {
        return DbManagerHolder.instance;
    }

    private static class DbManagerHolder {
        private static final DbManager instance = new DbManager();
    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "gfood.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
