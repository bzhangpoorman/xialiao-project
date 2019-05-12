package com.bzhang.xialiao;

import com.bzhang.xialiao.netty.ChatServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.bzhang.xialiao.mapper")
@ComponentScan(basePackages = {"com.bzhang.xialiao","org.n3r.idworker"})
public class XialiaoApplication implements CommandLineRunner {
	@Autowired
	private ChatServer chatServer;

	public static void main(String[] args) {
		SpringApplication.run(XialiaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		chatServer.start();
	}
}
