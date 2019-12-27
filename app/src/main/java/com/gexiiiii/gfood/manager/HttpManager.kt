package com.gexiiiii.gfood.manager

import com.gexiiiii.base.http.XHttpClient
import com.gexiiiii.gfood.http.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit



/**
 * author : Gexiiiii
 * date : 2019/12/5 10:26
 * description :
 */
object HttpManager {
    private val xHttpClient = XHttpClient()
    private var retrofit: Retrofit? = null
    private var mOkHttpClient: OkHttpClient? = null

    fun init(baseUrl: String) {
        mOkHttpClient = xHttpClient.initHttp()
        retrofit = xHttpClient.init(baseUrl)
    }

    fun api(): Api {
        return retrofit!!.create(Api::class.java)
    }
}