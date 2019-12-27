package com.gexiiiii.gfood.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.gexiiiii.base.utils.XDensityUtil
import com.gexiiiii.gfood.R

/**
 * author : Gexiiiii
 * date : 2019/12/4 17:06
 * description :
 */
class TitleBar : LinearLayout {
    //控件
    private var tvTitleLeft: TextView? = null
    private var tvTitleCenter: TextView? = null
    private var tvTitleRight: TextView? = null
    private var ivTitleLeft: ImageView? = null
    private var ivTitleRight: ImageView? = null
    var centerTabLayout: GTabLayout? = null

    private var imgHeight: Int? = 0
    private var textColor: Int? = 0
    private var textTitleColor: Int? = 0
    private var textLeft: String? = ""
    private var textCenter: String? = ""
    private var textRight: String? = ""
    private var imgLeft: Int? = 0
    private var imgRight: Int? = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(context, attrs)
        LayoutInflater.from(context).inflate(R.layout.widget_titlebar, this)
        initViews()
    }

    private fun initViews() {
        tvTitleLeft = findViewById(R.id.tvTitleLeft)
        tvTitleCenter = findViewById(R.id.tvTitleCenter)
        tvTitleRight = findViewById(R.id.tvTitleRight)
        ivTitleLeft = findViewById(R.id.ivTitleLeft)
        ivTitleRight = findViewById(R.id.ivTitleRight)
        centerTabLayout = findViewById(R.id.centerTabLayout)

        initLayout()
        setListeners()

        tvTitleLeft!!.text = textLeft
        tvTitleLeft!!.setTextColor(textColor!!)
        tvTitleCenter!!.text = textCenter
        tvTitleCenter!!.setTextColor(textTitleColor!!)
        tvTitleRight!!.text = textRight
        tvTitleRight!!.setTextColor(textColor!!)

        val params = ConstraintLayout.LayoutParams(
            XDensityUtil.getScreenWidth(context) / 2,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        params.leftToLeft = R.id.clTitleBar
        params.rightToRight = R.id.clTitleBar
        params.bottomToBottom = R.id.clTitleBar
        centerTabLayout!!.layoutParams = params

        if (imgHeight!! in 1..38) {
            val params =
                ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    XDensityUtil.dip2px(context, imgHeight!!.toFloat())
                )
            ivTitleLeft!!.layoutParams = params
            ivTitleRight!!.layoutParams = params
        }

        ivTitleLeft!!.setImageResource(imgLeft!!)
        ivTitleRight!!.setImageResource(imgRight!!)
    }

    private fun setListeners() {
        ivTitleLeft!!.setOnClickListener {
            if (titleBarClickListener != null) {
                titleBarClickListener!!.leftClick()
            }
        }
        tvTitleLeft!!.setOnClickListener {
            if (titleBarClickListener != null) {
                titleBarClickListener!!.leftClick()
            }
        }
        ivTitleRight!!.setOnClickListener {
            if (titleBarClickListener != null) {
                titleBarClickListener!!.rightClick()
            }
        }
        tvTitleRight!!.setOnClickListener {
            if (titleBarClickListener != null) {
                titleBarClickListener!!.rightClick()
            }
        }
    }

    fun setLeftText(text: String) {
        this.textLeft = text
        tvTitleLeft!!.text = text
        initLayout()
    }

    fun setCenterText(text: String) {
        this.textCenter = text
        tvTitleCenter!!.text = text
        initLayout()
    }

    fun setRightText(text: String) {
        this.textRight = text
        tvTitleRight!!.text = text
        initLayout()
    }

    fun setLeftIcon(resId: Int) {
        this.imgLeft = resId
        ivTitleLeft!!.setImageResource(resId)
        initLayout()
    }

    fun setRightIcon(resId: Int) {
        this.imgRight = resId
        ivTitleRight!!.setImageResource(resId)
        initLayout()
    }

    fun setLeftIconHeight(height: Int) {
        if (height in 1..38) {
            val params =
                ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    XDensityUtil.dip2px(context, height.toFloat())
                )
            ivTitleLeft!!.layoutParams = params
        }
    }

    fun setRightIconHeight(height: Int) {
        if (height in 1..38) {
            val params =
                ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    XDensityUtil.dip2px(context, height.toFloat())
                )
            ivTitleRight!!.layoutParams = params
        }
    }

    fun setLeftTextColor(resId: Int) {
        tvTitleLeft!!.setTextColor(resources.getColor(resId))
    }

    fun setCenterTextColor(resId: Int) {
        tvTitleCenter!!.setTextColor(resources.getColor(resId))
    }

    fun setRightTextColor(resId: Int) {
        tvTitleRight!!.setTextColor(resources.getColor(resId))
    }

    fun getLeftText(): String {
        return tvTitleLeft!!.text.toString()
    }

    fun getCenterText(): String {
        return tvTitleCenter!!.text.toString()
    }

    fun getRightText(): String {
        return tvTitleRight!!.text.toString()
    }

    fun showTab(isShow: Boolean) {
        centerTabLayout!!.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    private fun initLayout() {
        tvTitleLeft!!.visibility = if (textLeft != "") View.VISIBLE else View.GONE
        tvTitleCenter!!.visibility = if (textCenter != "") View.VISIBLE else View.GONE
        tvTitleRight!!.visibility = if (textRight != "") View.VISIBLE else View.GONE
        ivTitleLeft!!.visibility = if (imgLeft != 0) View.VISIBLE else View.GONE
        ivTitleRight!!.visibility = if (imgRight != 0) View.VISIBLE else View.GONE
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar)
        imgHeight = typedArray.getInt(R.styleable.TitleBar_imgHeight, 0)
        textColor = typedArray.getColor(R.styleable.TitleBar_textColor, Color.BLACK)
        textTitleColor = typedArray.getColor(R.styleable.TitleBar_textTitleColor, Color.BLACK)
        textLeft = typedArray.getString(R.styleable.TitleBar_textLeft)
        textCenter = typedArray.getString(R.styleable.TitleBar_textCenter)
        textRight = typedArray.getString(R.styleable.TitleBar_textRight)
        imgLeft = typedArray.getResourceId(R.styleable.TitleBar_imgLeft, 0)
        imgRight = typedArray.getResourceId(R.styleable.TitleBar_imgRight, 0)
        typedArray.recycle()
    }

    private var titleBarClickListener: TitleBarClickListener? = null

    fun setTitleBarClickListener(titleBarClickListener: TitleBarClickListener) {
        this.titleBarClickListener = titleBarClickListener
    }

    interface TitleBarClickListener {
        fun leftClick()
        fun rightClick()
    }
}