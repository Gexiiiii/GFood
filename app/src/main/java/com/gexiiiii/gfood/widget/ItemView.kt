package com.gexiiiii.gfood.widget

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.gexiiiii.gfood.R

/**
 * author : Gexiiiii
 * date : 2019/12/9 15:45
 * description :
 */
class ItemView : ConstraintLayout {

    private var vUnderLine: View? = null
    private var ivIconLeft: ImageView? = null
    private var ivIconRight: ImageView? = null
    private var tvTitle: TextView? = null
    private var layout: ConstraintLayout? = null

    private var isShowUnderLine = false
    private var title: String? = null
    private var titleStyle: Int? = null
    private var iconLeft: Int? = null
    private var iconRight: Int? = null
    private var background: Int? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(context, attrs)
        LayoutInflater.from(context).inflate(R.layout.widget_itemview, this)
        initViews()
    }

    private fun initViews() {
        vUnderLine = findViewById(R.id.vUnderLine)
        ivIconLeft = findViewById(R.id.ivLeftIcom)
        ivIconRight = findViewById(R.id.ivRightIcon)
        tvTitle = findViewById(R.id.tvTitle)
        layout = findViewById(R.id.clItemView)

        vUnderLine!!.visibility = if (isShowUnderLine) View.VISIBLE else View.GONE
        tvTitle!!.setTextAppearance(context, titleStyle!!)
        layout!!.setBackgroundResource(background!!)

        if (iconLeft != 0) {
            ivIconLeft!!.visibility = View.VISIBLE
            ivIconLeft!!.setImageResource(iconLeft!!)
        }

        if (iconRight != 0) {
            ivIconRight!!.visibility = View.VISIBLE
            ivIconRight!!.setImageResource(iconRight!!)
        }

        if (!TextUtils.isEmpty(title)) {
            tvTitle!!.text = title
        }
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemView)
        title = typedArray.getString(R.styleable.ItemView_title)
        titleStyle =
            typedArray.getResourceId(R.styleable.ItemView_title_style, R.style.BlackText_15sp)
        iconLeft = typedArray.getResourceId(R.styleable.ItemView_icon_left, 0)
        iconRight = typedArray.getResourceId(R.styleable.ItemView_icon_right, 0)
        background = typedArray.getResourceId(R.styleable.ItemView_background, R.drawable.bg_item)
        isShowUnderLine = typedArray.getBoolean(R.styleable.ItemView_isShowUnderLine, false)
        typedArray.recycle()
    }
}