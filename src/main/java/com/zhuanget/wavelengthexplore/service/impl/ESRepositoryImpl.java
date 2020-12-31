package com.zhuanget.wavelengthexplore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhuanget.wavelengthexplore.config.ESClientFactory;
import com.zhuanget.wavelengthexplore.enums.ESMethod;
import com.zhuanget.wavelengthexplore.service.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author Zhuang_ET
 * @since 2020-09-29 17:00:03
 */
@Service
@Slf4j
public class ESRepositoryImpl implements ESRepository {

    @Resource
    private ESClientFactory esClientFactory;

    @Override
    public boolean createIndex(String index, String setting) {
        // TODO：可以后期优化加入重试机制
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            Request request = new Request(ESMethod.PUT.getMethod(), "/" + index);
            // 设置setting
            request.setJsonEntity(setting);
            try {
                Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
                log.info("response.getEntity: {}", response.getEntity());
                return true;
            } catch (IOException e) {
                log.error("some errors happen when create index: ", e);
                return false;
            }
        } finally {
            silentClose(restHighLevelClient);
        }
    }

    @Override
    public boolean createMapping(String index, String mapping) {
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            Request request = new Request(ESMethod.POST.getMethod(), "/" + index + "/_mapping");
            // 设置mapping
            request.setJsonEntity(mapping);
            try {
                Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
                return true;
            } catch (IOException e) {
                log.error("some errors happen when create mappings: ", e);
            }
        }finally {
            silentClose(restHighLevelClient);
        }
        return false;
    }

    @Override
    public boolean createDocument(String index, Long id, JSONObject data) {
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            String endpoint = id == null ? index : index + "/" + id;
            Request request = new Request(ESMethod.POST.getMethod(), endpoint);
            HttpEntity httpEntity = new NStringEntity(data.toJSONString(), ContentType.APPLICATION_JSON);
            request.setEntity(httpEntity);
            Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
            log.info("response.entity: {}", response.getEntity());
            return true;
        } catch (IOException e) {
            log.error("insert doc to index[{}] error, e: ", index, e);
        } finally {
            silentClose(restHighLevelClient);
        }
        return false;
    }

    @Override
    public boolean checkIndex(String index) {
        RestHighLevelClient restHighLevelClient = null;
        try {
            restHighLevelClient = getClient();
            GetIndexRequest request = new GetIndexRequest();
            request.indices(index);
            return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("check index error, e: ", e);
        } finally {
            silentClose(restHighLevelClient);
        }
        return false;
    }

    @Override
    public JSONObject query(String index, Long id) {
        return null;
    }

    @Override
    public <T> int batchInsert(List<T> list, String index) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        String metaData = "{ \"index\":{} }\n";
        for (T obj : list) {
            sb.append(metaData).append(JSON.toJSONString(obj)).append('\n');
        }
        try (RestHighLevelClient restHighLevelClient = getClient()) {
            String endpoint = index + "/" + "_bulk";
            Request request = new Request(ESMethod.POST.getMethod(), endpoint);
            HttpEntity entity = new NStringEntity(sb.toString(), ContentType.APPLICATION_JSON);
            request.setEntity(entity);
            Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
            log.info("response.entity: {}", response.getEntity());
            return list.size();
        } catch (IOException e) {
            log.error("batch insert doc to index[{}] error, e: ", index, e);
        }
        return 0;
    }

    private RestHighLevelClient getClient() {
        return esClientFactory.newRestHighLevelClient();
    }

    private void silentClose(RestHighLevelClient restHighLevelClient) {
        if (restHighLevelClient == null) {
            return;
        }
        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            log.error("restClient close failed, error: ", e);
        }
    }
}
