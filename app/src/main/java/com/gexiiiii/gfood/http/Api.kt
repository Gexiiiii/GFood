package com.gexiiiii.gfood.http

import com.gexiiiii.gfood.bean.http.*
import io.reactivex.Observable
import retrofit2.http.*


/**
 * author : Gexiiiii
 * date : 2019/12/5 10:17
 * description :
 */
interface Api {

    companion object {
        const val BASE_URL: String = "http://v.juhe.cn/"
        const val LINE_URL: String = "http://apis.juhe.cn/"
    }

    /**
     * 获取新闻列表
     * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     */
    @GET("toutiao/index?key=${com.gexiiiii.gfood.manager.KeyManager.newsKey}")
    fun getNews(
        @Query("type") keywords: String
    ): Observable<NewsBean>

    /**
     * 获取天气
     */
    @GET("weather/index?key=${com.gexiiiii.gfood.manager.KeyManager.weatherKey}&format=2")
    fun getWeather(
        @Query("cityname") city: String
    ): Observable<WeatherBean>

    /**
     * 搜索菜谱
     */
    @Headers("Domain-Name:line")
    @GET("cook/query.php?key=${com.gexiiiii.gfood.manager.KeyManager.menuKey}&rn=15")
    fun searchMenu(
        @Query("menu") keywords: String,
        @Query("pn") position: String
    ): Observable<MenuBean>

    /**
     * 获取菜谱分类
     */
    @Headers("Domain-Name:line")
    @GET("cook/category?key=${com.gexiiiii.gfood.manager.KeyManager.menuKey}")
    fun getCategory(): Observable<CategoryBean>

    /**
     * 根据分类获取菜谱列表
     */
    @Headers("Domain-Name:line")
    @GET("cook/index?key=${com.gexiiiii.gfood.manager.KeyManager.menuKey}&rn=15")
    fun getMenuListFromCategoryId(
        @Query("cid") categoryId: Int,
        @Query("pn") position: String
    ): Observable<MenuBean>

    /**
     * 根据菜谱ID获取菜谱
     */
    @Headers("Domain-Name:line")
    @GET("cook/index?key=${com.gexiiiii.gfood.manager.KeyManager.menuKey}")
    fun getMenuFromMenuId(
        @Query("id") munuId: Int
    ): Observable<MenuBean>

    /**
     * 获取简单天气
     */
    @Headers("Domain-Name:line")
    @GET("simpleWeather/query?key=${com.gexiiiii.gfood.manager.KeyManager.simpleWeatherKey}")
    fun getSimpleWeather(
        @Query("city") city: String
    ): Observable<SimpleWeatherBean>

    /**
     * 获取历史今天列表
     * date  填  5/12
     */
    @GET("Onhistory/queryEvent.php?key=${com.gexiiiii.gfood.manager.KeyManager.TodayOnHistoryKey}")
    fun getHistoryList(
        @Query("date") date: String
    ): Observable<TodayOnHistoryBean>

    /**
     * 获取历史今天详细
     */
    @GET("Onhistory/queryDetail.php?key=${com.gexiiiii.gfood.manager.KeyManager.TodayOnHistoryKey}")
    fun getHistoryInfo(
        @Query("e_id") eventId: Int
    ): Observable<HistoryInfoBean>
}