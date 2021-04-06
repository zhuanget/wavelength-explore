package com.zhuanget.wavelengthexplore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuanget.wavelengthexplore.constant.GlobalConst;
import com.zhuanget.wavelengthexplore.dto.CarArchivesReq;
import com.zhuanget.wavelengthexplore.entity.CarArchivesInfo;
import com.zhuanget.wavelengthexplore.mapper.CarArchivesInfoMapper;
import com.zhuanget.wavelengthexplore.service.ESRepository;
import com.zhuanget.wavelengthexplore.service.InsertDataService;
import com.zhuanget.wavelengthexplore.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class WavelengthExploreApplicationTests {

	@Autowired
	private InsertDataService insertDataService;

	@Resource
	private CarArchivesInfoMapper carArchivesInfoMapper;

	@Value("${spring.datasource.username}")
	private String username;

	@Autowired
	private StringEncryptor stringEncryptor;

	@Resource
    private ESRepository esRepository;

	@Test
	void contextLoads() {
		log.info("hello");
	}

	@Test
	void mybatisInserts() {
		insertDataService.insertESData();
		log.info("success");
	}

	@Test
	void queryData() {
		String url = "http://192.168.13.21:27002/xapi/analysis/offline/v1.0";
		String strParam = "{\n" +
				"    \"bizCode\": \"bigdata\",\n" +
				"    \"taskType\": \"azkaban_collision\",\n" +
				"    \"opCode\": \"GetResult\",\n" +
				"    \"taskId\": \"2fa117f07db844bf9ba34de787e8224d\"\n" +
				"}";
		String strResp = HttpUtils.doPostJson(null, url, strParam);
		JSONObject resp = JSON.parseObject(strResp);
		log.info("resp: {}", resp.toJSONString());
	}

	@Test
	void carData() {
		List<CarArchivesInfo> carArchivesInfos = carArchivesInfoMapper.selectList(new QueryWrapper<>());
		List<String> plateNumbers = carArchivesInfos.stream().map(CarArchivesInfo::getPlateNumber).distinct().collect(Collectors.toList());
		CarArchivesReq carArchivesReq = new CarArchivesReq();
		carArchivesReq.setPlateNumbers(plateNumbers);
		long t1 = System.currentTimeMillis();
		List<Long> ids = carArchivesInfoMapper.countCarTotalNum(carArchivesReq);
		log.info("time1: {}", System.currentTimeMillis() - t1);

		List<Long> carIds = carArchivesInfos.stream().map(CarArchivesInfo::getId).distinct().collect(Collectors.toList());
		CarArchivesReq carArchivesReq1 = new CarArchivesReq();
		carArchivesReq1.setIds(carIds);
		long t2 = System.currentTimeMillis();
		List<Long> ids2 = carArchivesInfoMapper.countCarTotalNum(carArchivesReq1);
		log.info("time2: {}", System.currentTimeMillis() - t2);
	}

	@Test
	void datasource() {
		log.info("username: {}", username);
		String root = stringEncryptor.encrypt("root");
		log.info("root: {}", root);
		String password = stringEncryptor.encrypt("introcks1234");
		log.info("password:{}", password);
	}

	@Test
    void bodyData() {
//	    esRepository.createIndex(GlobalConst.BIGDATA_BODY_EVENT_INDEX, GlobalConst.NORMAL_SETTINGS);
//        esRepository.createMapping(GlobalConst.BIGDATA_BODY_EVENT_INDEX, GlobalConst.BODY_EVENT_MAPPINGS);
        insertDataService.addBodyArchiveData();
        log.info("success");
    }
}
