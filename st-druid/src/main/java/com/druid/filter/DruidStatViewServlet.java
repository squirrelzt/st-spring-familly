package com.druid.filter;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*",
initParams = {
        @WebInitParam(name = "loginUsername", value = "root"),
        @WebInitParam(name = "loginPassword", value = "123456"),
        @WebInitParam(name = "resetEnable", value = "false") //禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
