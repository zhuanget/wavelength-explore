package com.zhuanget.wavelengthexplore;

import com.zhuanget.wavelengthexplore.service.InsertDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Slf4j
class WavelengthExploreApplicationTests {

	@Autowired
	private InsertDataService insertDataService;

	@Test
	void contextLoads() {
		log.info("hello");
	}

	@Test
	void mybatisInserts() {
		insertDataService.insertESData();
		log.info("success");
	}

}
