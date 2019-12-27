package com.gexiiiii.gfood.ui

import com.gyf.immersionbar.ImmersionBar

/**
 * author : Gexiiiii
 * date : 2019/12/5 11:03
 * description :
 */
abstract class ImmNoTiTleActivity : GBaseActivity() {
    override fun initViews() {
        ImmersionBar.with(this)
            .transparentStatusBar()
            //状态栏内容深色
            .statusBarDarkFont(true)
            .init()
    }
}