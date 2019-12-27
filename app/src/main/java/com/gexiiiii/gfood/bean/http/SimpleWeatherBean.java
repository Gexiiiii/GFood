package com.gexiiiii.gfood.bean.http;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/5 14:13
 * description :
 */
public class SimpleWeatherBean extends BaseBean {

    /**
     * result : {"city":"长沙","realtime":{"temperature":"16","humidity":"26","info":"晴","wid":"00","direct":"西北风","power":"3级","aqi":"68"},"future":[{"date":"2019-12-05","temperature":"5/16℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"北风"},{"date":"2019-12-06","temperature":"3/14℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"北风"},{"date":"2019-12-07","temperature":"3/14℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"北风"},{"date":"2019-12-08","temperature":"4/16℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风"},{"date":"2019-12-09","temperature":"5/18℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东南风"}]}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * city : 长沙
         * realtime : {"temperature":"16","humidity":"26","info":"晴","wid":"00","direct":"西北风","power":"3级","aqi":"68"}
         * future : [{"date":"2019-12-05","temperature":"5/16℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"北风"},{"date":"2019-12-06","temperature":"3/14℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"北风"},{"date":"2019-12-07","temperature":"3/14℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"北风"},{"date":"2019-12-08","temperature":"4/16℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东北风"},{"date":"2019-12-09","temperature":"5/18℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东南风"}]
         */

        private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class RealtimeBean {
            /**
             * temperature : 16
             * humidity : 26
             * info : 晴
             * wid : 00
             * direct : 西北风
             * power : 3级
             * aqi : 68
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureBean {
            /**
             * date : 2019-12-05
             * temperature : 5/16℃
             * weather : 多云
             * wid : {"day":"01","night":"01"}
             * direct : 北风
             */

            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidBean getWid() {
                return wid;
            }

            public void setWid(WidBean wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidBean {
                /**
                 * day : 01
                 * night : 01
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }
}
