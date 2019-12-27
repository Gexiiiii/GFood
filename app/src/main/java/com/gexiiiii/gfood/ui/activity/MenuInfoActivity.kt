package com.gexiiiii.gfood.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.manager.DbManager
import com.gexiiiii.gfood.ui.ImmersionActivity
import com.gexiiiii.gfood.widget.TitleBar
import kotlinx.android.synthetic.main.activity_menu_info.*

class MenuInfoActivity : ImmersionActivity() {

    private var menuId: String? = null
    private var isFavorite = false

    override fun initVariable() {
        menuId = intent.getStringExtra("menuId")
        isFavorite =
            if (DbManager.getInstance().daoSession.favoriteMenuBeanDao.load(menuId) != null) {
                tbMenuInfo.setRightIcon(R.mipmap.ic_favorite_already)
                true
            } else {
                tbMenuInfo.setRightIcon(R.mipmap.ic_favorite_no)
                false
            }
    }

    override fun layoutResId(): Int {
        return R.layout.activity_menu_info
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        tbMenuInfo.setTitleBarClickListener(object : TitleBar.TitleBarClickListener {
            override fun leftClick() {
                finish()
            }

            override fun rightClick() {
                if (isFavorite) {
                    //删除收藏
                } else {
                    //添加收藏
                }
            }
        })
    }

    override fun titleBar(): TitleBar {
        return tbMenuInfo
    }

    companion object {
        fun start(context: Context, menuId: String) {
            val i = Intent(context, MenuInfoActivity::class.java)
            if (!TextUtils.isEmpty(menuId)) {
                i.putExtra("menuId", menuId)
            }
            context.startActivity(i)
        }
    }
}
