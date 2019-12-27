package com.gexiiiii.gfood.ui.fragment


import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.manager.DialogManager
import com.gexiiiii.gfood.ui.GBaseFragment
import kotlinx.android.synthetic.main.fragment_other.*
import kotlin.system.exitProcess

/**
 * author : Gexiiiii
 * date : 2019/12/6 11:19
 * description :
 */
class OtherFragment : GBaseFragment() {
    override fun initVariable() {
    }

    override fun initViews() {
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_other
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        tvVersion.text = "版本：${context!!.packageManager.getPackageInfo(context!!.packageName, 0).versionName}"

        ivTodayOnHistory.setOnClickListener {

        }
        ivNews.setOnClickListener {

        }
        ivAbout.setOnClickListener {

        }
    }
}
