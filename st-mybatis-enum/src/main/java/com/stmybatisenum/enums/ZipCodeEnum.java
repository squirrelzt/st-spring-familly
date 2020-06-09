package com.stmybatisenum.enums;

public enum ZipCodeEnum {
    BEIJING(100),
    SHENZHEN(200),
    HEBEI(300);

    private Integer code;
    ZipCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
