package com.mybatis.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("name")
    private String name;


    @TableField("age")
    private Integer age;


    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    @TableField(value = "updator", fill = FieldFill.UPDATE)
    private String updator;

    @TableField(value = "version", fill = FieldFill.INSERT_UPDATE)
    private String version;
}
