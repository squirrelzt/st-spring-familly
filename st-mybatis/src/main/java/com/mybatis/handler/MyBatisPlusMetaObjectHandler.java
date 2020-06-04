package com.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Value("${public-field.creator}")
    String creator;
    @Value("${public-field.updator}")
    String updator;
    @Value("${public-field.create-version}")
    String createVersion;
    @Value("${public-field.update-version}")
    String updateVersion;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        log.info(creator);
//        log.info(metaObject.toString());
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "creator", String.class, creator);
        this.strictInsertFill(metaObject, "version", String.class, createVersion);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
//        log.info(metaObject.toString());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "updator", String.class, updator);
        this.strictUpdateFill(metaObject, "version", String.class, updateVersion);
    }
}
