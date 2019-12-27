package com.gexiiiii.gfood.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gexiiiii.base.utils.XGlideUtil;
import com.gexiiiii.gfood.R;
import com.gexiiiii.gfood.bean.http.MenuBean;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/13 15:44
 * description :
 */
public class MenuListAdapter extends BaseQuickAdapter<MenuBean.ResultBean.DataBean, BaseViewHolder> {

    private Context context;

    public MenuListAdapter(Context context, List<MenuBean.ResultBean.DataBean> data) {
        super(R.layout.item_menu, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MenuBean.ResultBean.DataBean item) {
        helper.setIsRecyclable(false);
        ConstraintLayout cl = helper.getView(R.id.clMenu);
        ImageView iv = helper.getView(R.id.ivMenu);
        helper.setText(R.id.tvMenuName, item.getTitle());
        helper.setText(R.id.tvMenuTag, item.getTags());
        new XGlideUtil.Builder(iv, item.getAlbums().get(0))
                .setCornerType(XGlideUtil.TYPR_TOP)
                .setRadius(20)
                .build()
                .load();
        cl.setOnClickListener(v -> onClickListener.onClick(item.getId()));
    }

    private OnClickListener onClickListener;

    public interface OnClickListener {
        void onClick(String menuId);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
