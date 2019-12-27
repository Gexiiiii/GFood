package com.gexiiiii.gfood

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.gexiiiii.gfood.http.Api
import com.gexiiiii.gfood.manager.DbManager
import com.gexiiiii.gfood.manager.HttpManager
import com.gexiiiii.gfood.manager.SpManager
import me.jessyan.retrofiturlmanager.RetrofitUrlManager

/**
 * author : Gexiiiii
 * date : 2019/12/4 16:12
 * description :
 */
class GApplication : MultiDexApplication() {
    companion object {
        var application: Application? = null
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        appContext = applicationContext

        Thread(Runnable {
            SpManager.init(this)
            DbManager.getInstance().init(appContext)
            HttpManager.init(Api.BASE_URL)
            RetrofitUrlManager.getInstance().putDomain("line", Api.LINE_URL)
        }).start()
    }
}