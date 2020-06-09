package com.stmybatisenum.enums;

public enum ZipCodeEnum implements BaseEnum {
    BEIJING(100),
    SHENZHEN(200),
    HEBEI(300);

    private Integer value;
    ZipCodeEnum(Integer value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
