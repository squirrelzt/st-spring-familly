package com.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
//        log.info(metaObject.toString());
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "creator", String.class, "admin");
        this.strictInsertFill(metaObject, "version", String.class, "1.0.0");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
//        log.info(metaObject.toString());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "updator", String.class, "admin1");
        this.strictUpdateFill(metaObject, "version", String.class, "2.0.0");
    }
}
