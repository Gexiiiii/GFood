package com.gexiiiii.gfood.ui.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gexiiiii.gfood.R;
import com.gexiiiii.gfood.bean.http.CategoryBean;
import com.gexiiiii.gfood.widget.FlowLayout;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/10 10:08
 * description :
 */
public class CategoryAdapter extends BaseQuickAdapter<CategoryBean.ResultBean, BaseViewHolder> {

    private Context context;

    public CategoryAdapter(Context context, List<CategoryBean.ResultBean> data) {
        super(R.layout.item_category, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryBean.ResultBean item) {
        helper.setIsRecyclable(false);
        FlowLayout flowLayout = helper.getView(R.id.flCate);
        helper.setText(R.id.tvCateTitle, item.getName());
        flowLayout.addCateTags(item.getList());
        flowLayout.setOnTagClickListener((text, cateBean) -> onTagClickListener.onTagClick(cateBean));
    }

    private OnTagClickListener onTagClickListener;

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface OnTagClickListener {
        void onTagClick(CategoryBean.ResultBean.ListBean cateBean);
    }
}
