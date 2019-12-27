package com.gexiiiii.gfood.manager

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.gexiiiii.base.utils.XDensityUtil
import com.gexiiiii.gfood.R

/**
 * author : Gexiiiii
 * date : 2019/12/6 11:16
 * description :
 */
object DialogManager {

    fun showMsgDialog(
        ctx: Context,
        title: String,
        msg: String,
        posLis: DialogInterface.OnClickListener?
    ) {
        var builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setPositiveButton("确定", posLis)
        builder.setNegativeButton("取消", posLis)
        builder.show()
    }

    fun showTipsDialog(
        ctx: Context,
        title: String,
        msg: String,
        posLis: DialogInterface.OnClickListener?
    ) {
        var builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setPositiveButton("确定", posLis)
        builder.setCancelable(false)
        builder.show()
    }

    @SuppressLint("RestrictedApi")
    fun showEditDialong(ctx: Context, title: String, content: String, posLis: EditDialogCallback) {
        val paddingLeft = XDensityUtil.dip2px(ctx, 20f)
        val mEditText = EditText(ctx)
        mEditText.setTextAppearance(ctx, R.style.BlackText_16sp)
        val mBuilder = AlertDialog.Builder(ctx)
        mBuilder.setTitle(title)
        mEditText.setText(content)
        mEditText.setSelection(content.length)
        mBuilder.setPositiveButton("确定") { dialog, which ->
            posLis.positive(mEditText.text.toString())
        }
        mBuilder.setNegativeButton("取消", null)
        mBuilder.setView(mEditText, paddingLeft, paddingLeft, paddingLeft, 0)
        mBuilder.show()
    }

    interface EditDialogCallback {
        fun positive(value: String)
    }
}