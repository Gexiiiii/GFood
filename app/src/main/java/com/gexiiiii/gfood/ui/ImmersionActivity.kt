package com.gexiiiii.gfood.ui

import com.gexiiiii.gfood.listeners.ImmersionTitleListener
import com.gyf.immersionbar.ImmersionBar

/**
 * author : Gexiiiii
 * date : 2019/12/5 11:03
 * description :
 */
abstract class ImmersionActivity : GBaseActivity(), ImmersionTitleListener {
    override fun initViews() {
        ImmersionBar.with(this)
            .titleBar(titleBar())
            //状态栏内容深色
            .statusBarDarkFont(false)
            .init()
    }
}