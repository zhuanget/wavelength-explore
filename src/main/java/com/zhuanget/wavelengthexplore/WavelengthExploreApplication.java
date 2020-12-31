package com.zhuanget.wavelengthexplore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhuanget.wavelengthexplore.mapper")
public class WavelengthExploreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WavelengthExploreApplication.class, args);
	}

}
