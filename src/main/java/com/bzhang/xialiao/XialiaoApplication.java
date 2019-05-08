package com.bzhang.xialiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bzhang.xialiao.mapper")
public class XialiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XialiaoApplication.class, args);
	}

}
