package com.gexiiiii.gfood.bean.http;

import java.util.List;

/**
 * author : Gexiiiii
 * date : 2019/12/6 17:11
 * description :
 */
public class HistoryInfoBean extends BaseBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * e_id : 5639
         * title : 四川汶川发生8.0级大地震
         * content :     2008年5月12日 (农历四月初八)，四川汶川发生8.0级大地震。
         * 2008年05月12日14时28分4.0秒，在四川汶川县发生M8.0级地震，震中位于北纬31.0度，东经103.4度。截至2008年5月14日16时，四川省震区共发生余震3345 次，最大余震为6.1 级。据不完全统计，这次灾害截至2008年9月25日12时，汶川地震已确认69277人遇难，374643人受伤，失踪17923人。 目前四川地震重灾区面积达到6.5万平方公里，涉及到阿坝、绵阳、德阳、成都、广元、雅安等6个市、州，严重受灾的县区达到44个，受灾乡镇1061个，人口大约2000万人，根据有关方面介绍，直接受灾人数1000多万。中国将每年5月12日定为国家“防灾减灾日”。
         * 时间：2008年5月12日14时28分04.0秒 纬度：31.0°N 经度：103.4°E 深度：33km 震级：里氏8.0级 （中国地震局于5月18日已将汶川地震震级从7.8级修订为8级）最大烈度：11度 震中位置：四川汶川县映秀镇 都江堰市西21km（267°） 崇州市西北48km（327°） 大邑县西北48km（346°） 成都西北75km（302°） 历史背景： 汶川地震是中国自我国建国以来最为强烈的一次地震，直接严重受灾地区达10万平方公里。
         * 失去了美好的家园
         * 汶川地震抗震救灾专题     百度“汶川地震”百科
         * 2008年5.12汶川地震50位英雄少年事迹
         * http://news.sina.com.cn/z/08earthquake/
         * http://www.xinhuanet.com/xhwenchuan/
         * http://news.qq.com/zt/2008/dizhen/
         * picNo : 8
         * picUrl : [{"pic_title":"地震后的汶川","id":1,"url":"http://images.juheapi.com/history/5639_1.jpg"},{"pic_title":"","id":2,"url":"http://images.juheapi.com/history/5639_2.jpg"},{"pic_title":"","id":3,"url":"http://images.juheapi.com/history/5639_3.jpg"},{"pic_title":"","id":4,"url":"http://images.juheapi.com/history/5639_4.jpg"},{"pic_title":"凝聚力量在瞬间长鸣","id":5,"url":"http://images.juheapi.com/history/5639_5.jpg"},{"pic_title":"懂事的孩子在向英勇的战士敬礼","id":6,"url":"http://images.juheapi.com/history/5639_6.jpg"},{"pic_title":"温家宝总理安慰受伤儿童","id":7,"url":"http://images.juheapi.com/history/5639_7.jpg"},{"pic_title":"\u201c警花妈妈\u201d蒋晓娟两天哺乳8个娃娃","id":8,"url":"http://images.juheapi.com/history/5639_8.jpg"}]
         */

        private String e_id;
        private String title;
        private String content;
        private String picNo;
        private List<PicUrlBean> picUrl;

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicNo() {
            return picNo;
        }

        public void setPicNo(String picNo) {
            this.picNo = picNo;
        }

        public List<PicUrlBean> getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(List<PicUrlBean> picUrl) {
            this.picUrl = picUrl;
        }

        public static class PicUrlBean {
            /**
             * pic_title : 地震后的汶川
             * id : 1
             * url : http://images.juheapi.com/history/5639_1.jpg
             */

            private String pic_title;
            private int id;
            private String url;

            public String getPic_title() {
                return pic_title;
            }

            public void setPic_title(String pic_title) {
                this.pic_title = pic_title;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
