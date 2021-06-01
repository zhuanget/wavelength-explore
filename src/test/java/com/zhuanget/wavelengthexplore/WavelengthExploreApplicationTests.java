package com.zhuanget.wavelengthexplore;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhuanget.wavelengthexplore.constant.GlobalConst;
import com.zhuanget.wavelengthexplore.dto.CarArchivesReq;
import com.zhuanget.wavelengthexplore.entity.ArchiveBankRel;
import com.zhuanget.wavelengthexplore.entity.ArchiveInfoHistory;
import com.zhuanget.wavelengthexplore.entity.CarArchivesInfo;
import com.zhuanget.wavelengthexplore.mapper.ArchiveBankRelMapper;
import com.zhuanget.wavelengthexplore.mapper.ArchiveInfoHistoryMapper;
import com.zhuanget.wavelengthexplore.mapper.CarArchivesInfoMapper;
import com.zhuanget.wavelengthexplore.service.ArchiveBankRelService;
import com.zhuanget.wavelengthexplore.service.ESRepository;
import com.zhuanget.wavelengthexplore.service.InsertDataService;
import com.zhuanget.wavelengthexplore.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class WavelengthExploreApplicationTests {

	@Autowired
	private InsertDataService insertDataService;

	@Resource
	private CarArchivesInfoMapper carArchivesInfoMapper;

	@Resource
	private ArchiveInfoHistoryMapper archiveInfoHistoryMapper;

	@Resource
	private ArchiveBankRelMapper archiveBankRelMapper;

	@Autowired
	private ArchiveBankRelService archiveBankRelService;

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
		String root = stringEncryptor.encrypt("root");
		log.info("root: {}", root);
		String password = stringEncryptor.encrypt("introcks1234");
		log.info("password:{}", password);
		String dec = stringEncryptor.decrypt("rDZqUw9Jk0IT1MFkT5qOR79T7pkQln+I8OkeDtI0PFL1YlNTuYUzt8tteO1CtcOW");
		log.info("dec: {}", dec);
	}

	@Test
    void bodyData() {
//	    esRepository.createIndex(GlobalConst.BIGDATA_BODY_EVENT_INDEX, GlobalConst.NORMAL_SETTINGS);
//        esRepository.createMapping(GlobalConst.BIGDATA_BODY_EVENT_INDEX, GlobalConst.BODY_EVENT_MAPPINGS);
        insertDataService.addBodyArchiveData();
        log.info("success");
    }

    @Test
	void historyData() {
		LambdaQueryWrapper<ArchiveInfoHistory> queryWrapper = new LambdaQueryWrapper<ArchiveInfoHistory>()
				.select(ArchiveInfoHistory::getAid, ArchiveInfoHistory::getBankArchiveId, ArchiveInfoHistory::getBankEname,
						ArchiveInfoHistory::getBankId, ArchiveInfoHistory::getModifyTime)
				.isNotNull(ArchiveInfoHistory::getBankArchiveId)
				.orderByDesc(ArchiveInfoHistory::getModifyTime);
		List<ArchiveInfoHistory> archiveInfoHistories = archiveInfoHistoryMapper.selectList(queryWrapper);
		Map<String, List<ArchiveInfoHistory>> group = archiveInfoHistories.stream().collect(Collectors.groupingBy(ArchiveInfoHistory::getAid));
		List<ArchiveBankRel> rels = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<ArchiveBankRel> archiveBankRels = archiveBankRelMapper.selectList(new QueryWrapper<>());
		Map<String, ArchiveBankRel> relMap = new HashMap<>();
		for (ArchiveBankRel rel : archiveBankRels) {
			String hash = rel.getBankArchiveId() + ":" + rel.getBankEname() + ":" + rel.getBankId();
			set.add(hash);
			relMap.put(hash, rel);
		}
		for (Map.Entry<String, List<ArchiveInfoHistory>> entry : group.entrySet()) {
			for (ArchiveInfoHistory history : entry.getValue()) {
				String hash = history.getBankArchiveId() + ":" + history.getBankEname() + ":" + history.getBankId();
				if (set.contains(hash)) {
					if (relMap.containsKey(hash)) {
						ArchiveBankRel archiveBankRel = relMap.get(hash);
						archiveBankRel.setAid(history.getAid());
						ArchiveBankRel relCondition = new ArchiveBankRel()
								.setBankArchiveId(history.getBankArchiveId())
								.setBankId(history.getBankId());
						archiveBankRelMapper.update(archiveBankRel, new UpdateWrapper<>(relCondition));
					}
				} else {
					ArchiveBankRel archiveBankRel = new ArchiveBankRel();
					archiveBankRel.setAid(history.getAid())
							.setBankArchiveId(history.getBankArchiveId())
							.setBankEname(history.getBankEname())
							.setBankId(history.getBankId());
					rels.add(archiveBankRel);
					set.add(hash);
				}
			}
		}
		if (CollectionUtils.isNotEmpty(rels)) {
			archiveBankRelService.saveBatch(rels);
		}
		log.info("test");
	}
}
