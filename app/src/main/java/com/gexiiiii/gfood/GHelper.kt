package com.gexiiiii.gfood

import com.gexiiiii.gfood.bean.AppConfigBean
import com.gexiiiii.gfood.config.AppConfig
import com.gexiiiii.gfood.manager.SpManager

/**
 * author : Gexiiiii
 * date : 2019/12/4 16:15
 * description :
 */
object GHelper {
    var appConfig = SpManager.appConfig ?: AppConfig()
    var appConfigBean: AppConfigBean? = appConfig.appConfigBean

    fun resetAppConfig(appConfigBean: AppConfigBean) {
        this.appConfigBean = appConfigBean
        appConfig.appConfigBean = appConfigBean
        SpManager.appConfig = appConfig
    }
}