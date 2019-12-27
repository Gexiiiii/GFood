package com.gexiiiii.gfood.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.gexiiiii.gfood.R;

/**
 * author : Gexiiiii
 * date : 2019/12/11 16:00
 * description :
 */
public class EmptyView extends ConstraintLayout {

    public EmptyView(Context context) {
        this(context,null);
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_empty, this);
    }
}
