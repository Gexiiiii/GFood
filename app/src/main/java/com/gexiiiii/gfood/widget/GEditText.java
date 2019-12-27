package com.gexiiiii.gfood.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.gexiiiii.gfood.R;

/**
 * author : Gexiiiii
 * date : 2019/12/4 17:06
 * description :
 */
public class GEditText extends ConstraintLayout {

    private ImageView ivEditIcon;
    private TextView tvEditTitle;
    private EditText etEditContent;
    private View vEditLine;

    private int etIcon, etInputType, etMaxLength;
    private String etTitle, etHint;
    private boolean etIsShowUnderLine;


    public GEditText(Context context) {
        this(context, null);
    }

    public GEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_edittext, this);
        initViews();
    }

    private void initViews() {
        ivEditIcon = findViewById(R.id.ivEditIcon);
        tvEditTitle = findViewById(R.id.tvEditTitle);
        etEditContent = findViewById(R.id.etEditContent);
        vEditLine = findViewById(R.id.vEditLine);

        if (!TextUtils.isEmpty(etTitle)) {
            tvEditTitle.setVisibility(VISIBLE);
            tvEditTitle.setText(etTitle);
        }

        if (!TextUtils.isEmpty(etHint)) {
            etEditContent.setHint(etHint);
        }

        if (etIsShowUnderLine) {
            vEditLine.setVisibility(VISIBLE);
        } else {
            vEditLine.setVisibility(GONE);
        }

        if (etIcon != 0) {
            ivEditIcon.setImageResource(etIcon);
            ivEditIcon.setVisibility(VISIBLE);
        }

        switch (etInputType) {
            case 0:
                etEditContent.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                break;
            case 1:
                etEditContent.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case 2:
                etEditContent.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                break;
        }

        if (etMaxLength != 0) {
            etEditContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(etMaxLength)});
        }
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GEditText);
        etIcon = typedArray.getResourceId(R.styleable.GEditText_etIcon, 0);
        etInputType = typedArray.getInt(R.styleable.GEditText_etInputType, 0);
        etMaxLength = typedArray.getInt(R.styleable.GEditText_etMaxLength, 0);
        etTitle = typedArray.getString(R.styleable.GEditText_etTitle);
        etHint = typedArray.getString(R.styleable.GEditText_etHint);
        etIsShowUnderLine = typedArray.getBoolean(R.styleable.GEditText_etIsShowUnderLine, true);
        typedArray.recycle();
    }

    public void setText(String text) {
        etEditContent.setText(text);
        etEditContent.setSelection(text.length());
    }

    public String getText() {
        return etEditContent.getText().toString();
    }
}
