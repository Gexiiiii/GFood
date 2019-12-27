package com.gexiiiii.gfood.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gexiiiii.base.utils.XGlideUtil;
import com.gexiiiii.gfood.R;
import com.gexiiiii.gfood.bean.db.LookHistoryBean;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/17 15:36
 * description :
 */
public class LookHistoryAdapter extends BaseQuickAdapter<LookHistoryBean, BaseViewHolder> {

    private Context context;

    public LookHistoryAdapter(Context context, List<LookHistoryBean> data) {
        super(R.layout.item_lookhistory, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, LookHistoryBean item) {
        helper.setIsRecyclable(false);
        ImageView iv = helper.getView(R.id.ivLookHistory);
        helper.setText(R.id.tvLookHistoryTitle, item.getTitle());
        helper.setText(R.id.tvLookHistoryTags, item.getTags());
        new XGlideUtil.Builder(iv, item.getAlbums())
                .setCornerType(XGlideUtil.TYPR_ALL)
                .setRadius(20)
                .build()
                .load();
    }
}
