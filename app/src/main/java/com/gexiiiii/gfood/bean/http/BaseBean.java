package com.gexiiiii.gfood.bean.http;

/**
 * author : Gexiiiii
 * date : 2019/12/5 11:39
 * description :
 */
public class BaseBean {
    private String resultcode;
    private String reason;
    private int error_code;

    public BaseBean() {
    }

    public BaseBean(String resultcode, String reason, int error_code) {
        this.resultcode = resultcode;
        this.reason = reason;
        this.error_code = error_code;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
