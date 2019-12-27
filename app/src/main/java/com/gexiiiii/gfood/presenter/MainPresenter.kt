package com.gexiiiii.gfood.presenter

import android.util.Log
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.gexiiiii.gfood.GApplication
import com.gexiiiii.gfood.contract.MainContract
import com.gexiiiii.gfood.manager.HttpManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * author : Gexiiiii
 * date : 2019/12/6 16:12
 * description :
 */
class MainPresenter : MainContract.Presenter, AMapLocationListener {

    /**
     * 声明mlocationClient对象
     */
    private var mLocationClient: AMapLocationClient? = null
    /**
     * 声明mLocationOption对象
     */
    private var mLocationOption: AMapLocationClientOption? = null

    override fun getCity() {
        mLocationClient = AMapLocationClient(GApplication.appContext)
        mLocationOption = AMapLocationClientOption()
        // 设置定位监听
        mLocationClient!!.setLocationListener(this)
        // 设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption!!.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        // 设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption!!.interval = 15 * 60 * 1000
        // 设置定位参数
        mLocationClient!!.setLocationOption(mLocationOption)
        //启动定位
        mLocationClient!!.startLocation()
    }

    override fun onLocationChanged(p0: AMapLocation?) {
        if (p0 != null) {
            if (p0.errorCode == 0) {
                mView!!.getCitySuccess(p0.city, p0.time)
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e(
                    "AmapError",
                    "location Error, ErrCode:" + p0.errorCode + ", errInfo:" + p0.errorInfo
                )
                mView!!.showToast("定位：${p0.errorInfo}")
            }
        }
    }

    override fun getWeather(city: String) {
        HttpManager.api()
            .getSimpleWeather(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView!!.getWeatherSuccess(it)
                mView!!.showToast("天气：${it.reason}")
            }
    }

    override fun getCategory() {
        HttpManager.api()
            .getCategory()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView!!.getCategorySuccess(it)
                mView!!.showToast("菜谱分类：${it.reason}")
            }
    }

    private var mView: MainContract.View? = null

    override fun dropView() {
        mView = null
    }

    override fun takeView(view: MainContract.View) {
        mView = view
    }
}