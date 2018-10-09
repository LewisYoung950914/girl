package com.deadcrow.girl.enums;

public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(10001, "成功"),
    FAIL(10000,"失败"),
    YOUNV(20010, "幼女"),
    LORY(20011, "萝莉"),
    YUJIE(20012, "御姐");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
