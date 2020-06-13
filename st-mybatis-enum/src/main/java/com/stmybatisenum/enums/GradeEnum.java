package com.stmybatisenum.enums;

public enum GradeEnum {
    ONE(1),
    TWO(2),
    THREE(3);

    private Integer value;
    GradeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
