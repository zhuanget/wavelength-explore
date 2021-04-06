package com.zhuanget.wavelengthexplore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zhuanget.wavelengthexplore.constant.GlobalConst;
import com.zhuanget.wavelengthexplore.dto.BodyEventDTO;
import com.zhuanget.wavelengthexplore.dto.CarEventInfoDTO;
import com.zhuanget.wavelengthexplore.dto.EventInfoDTO;
import com.zhuanget.wavelengthexplore.entity.FaceBelongDetailDTO;
import com.zhuanget.wavelengthexplore.service.ESRepository;
import com.zhuanget.wavelengthexplore.service.InsertDataService;
import com.zhuanget.wavelengthexplore.util.DateUtil;
import com.zhuanget.wavelengthexplore.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Zhuang_ET
 * @since 2021-01-18 17:22:13
 */
@Service
@Slf4j
public class InsertDataServiceImpl implements InsertDataService {

    @Autowired
    private ESRepository esRepository;

    @Override
    public void insertESData() {

//        List<FaceBelongDetailDTO> detailDTOList = new ArrayList<>();
//        String[] aids = new String[]{"793874325534019584", "4627818476889702405", "4628102529383661609", "747779817923022848"};
//        String[] plateNumbers = new String[]{"粤BM824F", "粤BR393P", "粤B1DJ10", "粤BX133Y", "粤B6L62F", "粤B44KK9", "粤B318QK"};
//        Map<String, List<CarEventInfoDTO>> carMap = new HashMap<>();
//        String carUrl = "http://192.168.13.20:32004/collection/api/analyze/resource/result/list/1.0";
//        String faceUrl = "http://192.168.11.112:32105/analysis/archive/eventflow/list/1.0";
//        for (String plateNumber : plateNumbers) {
//            JSONObject req = buildParam(plateNumber);
//            String strResp = HttpUtils.doPostJson(null, carUrl, req.toJSONString());
//            JSONObject resp = JSON.parseObject(strResp);
//            JSONArray data = resp.getJSONArray("data");
//            for (int k = 0; k < data.size(); k++) {
//                JSONObject jsonObject = data.getJSONObject(k);
//                JSONArray cars = jsonObject.getJSONArray("cars");
//                JSONObject carJson = cars.getJSONObject(0);
//                if (carMap.containsKey(plateNumber)) {
//                    carMap.get(plateNumber).add(carJson.toJavaObject(CarEventInfoDTO.class));
//                } else {
//                    carMap.put(plateNumber, Lists.newArrayList(carJson.toJavaObject(CarEventInfoDTO.class)));
//                }
//            }
//        }
//        Map<String, List<EventInfoDTO>> faceMap = new HashMap<>();
//        for (String aid : aids) {
//            JSONObject param = new JSONObject();
//            param.put("startTime", LocalDate.now().minusDays(30).format(DateUtil.DTF_YMD));
//            param.put("endTime", LocalDate.now().format(DateUtil.DTF_YMD));
//            param.put("personFileId", aid);
//            param.put("page", 1);
//            param.put("pageSize", 20);
//            String strResp = HttpUtils.doPostJson(null, faceUrl, param.toJSONString());
//            JSONObject resp = JSON.parseObject(strResp);
//            JSONArray data = resp.getJSONArray("data");
//            for (int i = 0; i < data.size(); i++) {
//                JSONObject dateEvent = data.getJSONObject(i);
//                JSONArray snap = dateEvent.getJSONArray("snap");
//                if (faceMap.containsKey(aid)) {
//                    faceMap.get(aid).addAll(snap.toJavaList(EventInfoDTO.class));
//                } else {
//                    faceMap.put(aid, snap.toJavaList(EventInfoDTO.class));
//                }
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            String plateNumber = plateNumbers[i];
//            List<CarEventInfoDTO> carEvents = carMap.get(plateNumber);
//            if (CollectionUtils.isEmpty(carEvents)) {
//                continue;
//            }
//            for (CarEventInfoDTO carEvent : carEvents) {
//                for (int j = 0; j < 4; j++) {
//                    String aid = aids[j];
//                    List<EventInfoDTO> events = faceMap.get(aid);
//                    for (EventInfoDTO event : events) {
//                        FaceBelongDetailDTO faceBelongDetailDTO = new FaceBelongDetailDTO()
//                                .setPersonTime(event.getSnapTime())
//                                .setPersonThumbnailUrl(event.getFaceUrl())
//                                .setPersonThumbnailId(event.getFaceId())
//                                .setPersonSourceId(event.getSourceId())
//                                .setPersonScore(null)
//                                .setPersonImageUrl(event.getImageUrl())
//                                .setPersonImageId(event.getImageId())
//                                .setPersonGuid(null)
//                                .setPersonAid(aid)
//                                .setDataType("0")
//                                .setCollDt(event.getSnapTime())
//                                .setCarTime(carEvent.getTime())
//                                .setCarThumbnailUrl(carEvent.getSmallUrl())
//                                .setCarThumbnailId(carEvent.getId())
//                                .setBizCode("matrix")
//                                .setCarGuid(carEvent.getGuid())
//                                .setCarNo(plateNumber)
//                                .setCarSourceId(carEvent.getSourceId());
//                        detailDTOList.add(faceBelongDetailDTO);
//                    }
//
//                }
//            }
//        }
//        log.info("detailList.size: {}", detailDTOList.size());
//        for (int i = 0; i < 60; i++) {
//            int startId = i * 100;
//            int endId = Math.min((i + 1) * 100, detailDTOList.size());
//            esRepository.batchInsert(detailDTOList.subList(startId, endId), "matrix_car_event_face_belong");
//        }
        String index = "matrix_event_multi";
        JSONObject eventMulti = new JSONObject();
        eventMulti.put("id", "10203493495");
        eventMulti.put("aid", "801045797427875840");
        eventMulti.put("data_code", "3702111994050001");
        eventMulti.put("data_type", "SCENIC_AREA_BOOKING");
        eventMulti.put("time", 1612507001471L);
        eventMulti.put("coll_dt", 1612507001471L);
        eventMulti.put("location", "");
        eventMulti.put("geo_hash", "");
        eventMulti.put("guid", "10203493495");
        eventMulti.put("create_time", 1612507001471L);
        eventMulti.put("modify_time", 1612507001471L);
        eventMulti.put("source_id", "18");
        eventMulti.put("source_type", "hikson");
        eventMulti.put("status", 0);
        JSONObject props = new JSONObject();
        props.put("time", "2021-02-05 00:05:23");
        eventMulti.put("props", props.toJSONString());
        esRepository.batchInsert(Lists.newArrayList(eventMulti), index);
    }

    @Override
    public void addBodyArchiveData() {
        String url = "http://192.168.13.33:32107/deepeye/api/search/muti/mutiobj/1.0";
        String imageId = "2815137117727689401";
        String aid = "4632350991579087097";
        JSONObject param = buildBodySearchParam(imageId);
        String strResp = HttpUtils.doPostJson(null, url, param.toJSONString());
        JSONObject resp = JSON.parseObject(strResp);
        List<BodyEventDTO> bodyEvents = processData(resp, aid);
        esRepository.batchInsert(bodyEvents, GlobalConst.BIGDATA_BODY_EVENT_INDEX, GlobalConst.BIGDATA_BODY_EVENT_TYPE);
    }

    private List<BodyEventDTO> processData(JSONObject resp, String aid) {
        List<BodyEventDTO> res = new ArrayList<>();
        if (resp == null || resp.getJSONObject("data") == null) {
            return res;
        }
        JSONObject data = resp.getJSONObject("data");
        JSONArray results = data.getJSONArray("results");
        if (CollectionUtils.isEmpty(results)) {
            return res;
        }
        for (int i = 0; i < results.size(); i++) {
            JSONObject perData = results.getJSONObject(i);
            JSONArray bodies = perData.getJSONArray("bodies");
            for (int j = 0; j < bodies.size(); j++) {
                JSONObject body = bodies.getJSONObject(j);
                JSONObject attr = body.getJSONObject("attribute");
                BodyEventDTO bodyEventDTO = new BodyEventDTO()
                        .setBodyBikeRelationId(attr.getString("bodyBikeRelationId"))
                        .setVersion(body.getString("version"))
                        .setTrackId(body.getString("trackId"))
                        .setTime(DateUtil.parseStringToDate(body.getString("time")).getTime())
                        .setThumbnailUrl(body.getString("file"))
                        .setThumbnailId(body.getString("id"))
                        .setTargetType(body.getString("targetType"))
                        .setTargetRect(body.getString("targetRect"))
                        .setSourceType(body.getString("sourceType"))
                        .setSourceId(attr.getString("sourceId"))
                        .setRelationId(attr.getString("relationId"))
                        .setLatlon(null)
                        .setIsDelete(0)
                        .setImgQuality(attr.getString("imgQuality"))
                        .setImageUrl(attr.getString("backgroundImage"))
                        .setImageId(attr.getString("fromImageId"))
                        .setDt(DateUtil.parseStringToDate(body.getString("time")).getTime())
                        .setCreateTime(DateUtil.parseStringToDate(body.getString("create_time")).getTime())
                        .setAreaId(attr.getString("areaId"))
                        .setAid(aid)
                        .setFaceBodyRelationId(body.getString("facebodyrelationid"))
                        .setBodyIntegrity(null);
                log.info("body: {}", JSON.toJSONString(bodyEventDTO));
                res.add(bodyEventDTO);
            }
        }
        return res;
    }

    private JSONObject buildBodySearchParam(String imageId) {
        JSONObject param = new JSONObject();
        param.put("type", "collection");
        param.put("threshold", 0.5);
        param.put("startTime", "2021-03-12 00:00:00");
        param.put("endTime", "2021-03-12 23:59:59");
        param.put("sort", "score");
        param.put("sortType", "desc");
        param.put("page", 1);
        param.put("pageSize", 1000);
        param.put("mergeType", 1);
        param.put("targets", Lists.newArrayList("body"));
        JSONObject filterMap = new JSONObject();
        filterMap.put("targetType", "body");
        filterMap.put("attribute", new JSONObject());
        param.put("filterMap", Lists.newArrayList(filterMap));
        JSONObject image = new JSONObject();
        image.put("imageType", "id");
        image.put("imageData", imageId);
        image.put("targetType", "body");
        image.put("dataType", "collection");
        image.put("startTime", "2021-03-12 00:00:00");
        image.put("endTime", "2021-03-12 23:59:59");
        param.put("image", Lists.newArrayList(image));
        log.info("request param: {}", param.toJSONString());
        return param;
    }

    private JSONObject buildParam(String plateNumber) {
        JSONObject req = new JSONObject();
        JSONArray orBeanList = new JSONArray();
        req.put("orBeanList", orBeanList);
        JSONArray andBean = new JSONArray();
        req.put("andBean", andBean);
        JSONArray var1 = new JSONArray();
        JSONArray var2 = new JSONArray();
        JSONObject var3 = new JSONObject();
        var3.put("field", "plateNumber");
        var3.put("value", plateNumber);
        var3.put("operator", "EQ");
        var2.add(var3);
        var1.add(var2);
        orBeanList.add(var1);
        JSONObject gteTime = new JSONObject();
        JSONObject lteTime = new JSONObject();
        JSONObject pageSize = new JSONObject();
        JSONObject pageNo = new JSONObject();
        JSONObject targetType = new JSONObject();
        JSONObject operator = new JSONObject();
        andBean.add(gteTime);
        andBean.add(lteTime);
        andBean.add(pageSize);
        andBean.add(pageNo);
        andBean.add(targetType);
        andBean.add(operator);
        gteTime.put("field", "time");
        gteTime.put("value", LocalDateTime.now().minusDays(2).format(DateUtil.DTF_YMD_HMS));
        gteTime.put("operator", "GTE");
        lteTime.put("field", "time");
        lteTime.put("value", LocalDateTime.now().format(DateUtil.DTF_YMD_HMS));
        lteTime.put("operator", "LTE");
        pageSize.put("field", "pageSize");
        pageSize.put("value", "20");
        pageSize.put("operator", "EQ");
        pageNo.put("field", "pageNo");
        pageNo.put("value", "1");
        pageNo.put("operator", "EQ");
        targetType.put("field", "targetType");
        targetType.put("value", "car");
        targetType.put("operator", "EQ");
        operator.put("field", "operator");
        operator.put("value", "ifaas-engine");
        operator.put("operator", "EQ");
        req.put("sort", "desc");
        req.put("sequence", 0);
        req.put("partitionId", 0);
        log.info("请求参数：{}", req.toJSONString());
        return req;
    }


}
