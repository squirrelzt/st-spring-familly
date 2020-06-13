package com.stmybatisenum.enums;

public enum HasCarEnum {
    YES(1),
    NO(0);

    private Integer value;

    HasCarEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
