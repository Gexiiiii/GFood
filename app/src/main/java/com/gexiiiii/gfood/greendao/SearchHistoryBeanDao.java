package com.gexiiiii.gfood.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.gexiiiii.gfood.bean.db.SearchHistoryBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "t_search_history".
*/
public class SearchHistoryBeanDao extends AbstractDao<SearchHistoryBean, String> {

    public static final String TABLENAME = "t_search_history";

    /**
     * Properties of entity SearchHistoryBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Keyword = new Property(0, String.class, "keyword", true, "KEYWORD");
        public final static Property Date = new Property(1, long.class, "date", false, "DATE");
    }


    public SearchHistoryBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SearchHistoryBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"t_search_history\" (" + //
                "\"KEYWORD\" TEXT PRIMARY KEY NOT NULL ," + // 0: keyword
                "\"DATE\" INTEGER NOT NULL );"); // 1: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"t_search_history\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SearchHistoryBean entity) {
        stmt.clearBindings();
 
        String keyword = entity.getKeyword();
        if (keyword != null) {
            stmt.bindString(1, keyword);
        }
        stmt.bindLong(2, entity.getDate());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SearchHistoryBean entity) {
        stmt.clearBindings();
 
        String keyword = entity.getKeyword();
        if (keyword != null) {
            stmt.bindString(1, keyword);
        }
        stmt.bindLong(2, entity.getDate());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public SearchHistoryBean readEntity(Cursor cursor, int offset) {
        SearchHistoryBean entity = new SearchHistoryBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // keyword
            cursor.getLong(offset + 1) // date
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SearchHistoryBean entity, int offset) {
        entity.setKeyword(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDate(cursor.getLong(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(SearchHistoryBean entity, long rowId) {
        return entity.getKeyword();
    }
    
    @Override
    public String getKey(SearchHistoryBean entity) {
        if(entity != null) {
            return entity.getKeyword();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SearchHistoryBean entity) {
        return entity.getKeyword() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}