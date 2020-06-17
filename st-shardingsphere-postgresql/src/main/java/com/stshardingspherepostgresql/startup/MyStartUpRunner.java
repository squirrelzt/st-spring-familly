package com.stshardingspherepostgresql.startup;

import com.stshardingspherepostgresql.mapper.PersonMapper;
import com.stshardingspherepostgresql.model.Person;
import com.stshardingspherepostgresql.model.PersonExample;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Order(value = 5)
public class MyStartUpRunner implements CommandLineRunner {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    PersonMapper personMapper;

    @Override
    public void run(String... args) throws Exception {
//        select();
//        generator();
//        showConnection();
//        showData();
    }

    private void select() {
        PersonExample example = new PersonExample();
        List<Person> list = personMapper.selectByExample(example);
        log.info("******************");
        log.info(list.toString());
    }
    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info("-----------------------");
        log.info(conn.toString());
//        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM t_person")
                .forEach(row -> log.info(row.toString()));
    }

    private void generator() throws Exception {
        log.info("-----------------------");
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
