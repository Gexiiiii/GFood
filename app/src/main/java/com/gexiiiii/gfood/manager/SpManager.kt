package com.gexiiiii.gfood.manager

import android.content.Context
import android.content.SharedPreferences
import com.gexiiiii.gfood.config.AppConfig
import com.google.gson.Gson

/**
 * author : Gexiiiii
 * date : 2019/12/4 16:19
 * description :
 */
object SpManager {
    private const val PREFERENCE_NAME = "saveInfo"
    private const val KEY_APP_CONFIG = "appConfig"

    private var sp: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun init(ctx: Context) {
        sp = ctx.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        editor = sp!!.edit()
    }

    /**
     * app配置参数
     */
    var appConfig: AppConfig? = null
        set(value) {
            val config = Gson().toJson(value, AppConfig::class.java)
            editor?.putString(KEY_APP_CONFIG, config)
            editor?.apply()
            field = value
        }
        get() {
            if (field == null) {
                var config = sp?.getString(KEY_APP_CONFIG, null)
                field = Gson().fromJson(config, AppConfig::class.java)
            }
            return field
        }

    private const val KEY_IS_FIRST_LOGIN = "isFirstUse"
    var isFirstUse = false
        set(value) {
            editor?.putBoolean(KEY_IS_FIRST_LOGIN, value)
            editor?.apply()
            field = value
        }
        get() {
            field = sp!!.getBoolean(KEY_IS_FIRST_LOGIN, true)
            return field
        }
}