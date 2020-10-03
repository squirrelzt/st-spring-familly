package com.stjapidocs;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StJapiDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StJapiDocsApplication.class, args);
		DocsConfig config = new DocsConfig();
		config.setProjectPath("D:\\workspace\\java\\st-spring-familly\\st-japi-docs"); // root project path
		config.setProjectName("st-japi-docs"); // project name
		config.setApiVersion("V1.0");       // api version
		config.setDocsPath("D:\\workspace\\java\\st-spring-familly\\st-japi-docs"); // api docs target path
		config.setAutoGenerate(Boolean.TRUE);  // auto generate
		Docs.buildHtmlDocs(config); // execute to generate
	}

}
