package com.dongnaoedu.mycat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan("com.dongnaoedu.mycat.mapper")
public class SpringBootMycatApplication implements WebMvcConfigurer, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMycatApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        System.out.println("服务启动完成!");
    }

    @RequestMapping("/")
    String home() {
        return "redirect:employee";
    }
}
