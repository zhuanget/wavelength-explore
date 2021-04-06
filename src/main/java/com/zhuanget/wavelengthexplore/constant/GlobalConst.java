package com.zhuanget.wavelengthexplore.constant;

/**
 * 全局变量
 * @author Zhuang_ET
 * @since 2020-12-31 11:08:25
 */
public class GlobalConst {

    private GlobalConst() {}

    public static final String NORMAL_SETTINGS = "{\n" +
            "    \"settings\": {\n" +
            "        \"index\": {\n" +
            "            \"number_of_shards\": \"1\",\n" +
            "            \"number_of_replicas\": \"0\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String SIMPLE_BOOK_SETTINGS = "{\n" +
            "    \"settings\": {\n" +
            "        \"index\": {\n" +
            "            \"number_of_shards\": \"1\",\n" +
            "            \"analysis\": {\n" +
            "                \"analyzer\": {\n" +
            "                    \"ik_syno\": {\n" +
            "                        \"type\": \"custom\",\n" +
            "                        \"tokenizer\": \"ik_smart\"\n" +
            "                    },\n" +
            "                    \"ik_syno_max\": {\n" +
            "                        \"type\": \"custom\",\n" +
            "                        \"tokenizer\": \"ik_max_word\"\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"number_of_replicas\": \"0\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String SIMPLE_BOOK_MAPPINGS = "{\n" +
            "    \"properties\": {\n" +
            "        \"id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"name\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"image_url\": {\n" +
            "            \"type\": \"keyword\",\n" +
            "            \"index\": false\n" +
            "        },\n" +
            "        \"user\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"user_home\": {\n" +
            "            \"type\": \"text\",\n" +
            "            \"analyzer\": \"ik_syno_max\",\n" +
            "            \"search_analyzer\": \"ik_syno\"\n" +
            "        },\n" +
            "        \"create_time\": {\n" +
            "            \"type\": \"date\",\n" +
            "            \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
            "        },\n" +
            "        \"update_time\": {\n" +
            "            \"type\": \"date\",\n" +
            "            \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String BIGDATA_BODY_EVENT_INDEX = "bigdata_body_event";

    public static final String BIGDATA_BODY_EVENT_TYPE = "event";

    public static final String BODY_EVENT_MAPPINGS = "{\n" +
            "    \"properties\": {\n" +
            "        \"id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"dt\": {\n" +
            "            \"type\": \"long\"\n" +
            "        },\n" +
            "        \"cid\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"latlon\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"sys_code\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"aid\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"thumbnail_id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"thumbnail_url\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"image_id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"image_url\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"algo_version\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"feature_quality\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"body_integrity\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"body_location\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"track_id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"img_quality\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"target_type\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"area_id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"body_bike_relationid\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"face_body_relationid\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"cover_confidence\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"quality_info\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"target_rect\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"target_rect_float\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"img_rect\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"img_rect_float\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"source_id\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"source_type\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"time\": {\n" +
            "            \"type\": \"long\"\n" +
            "        },\n" +
            "        \"create_time\": {\n" +
            "            \"type\": \"long\"\n" +
            "        },\n" +
            "        \"column1\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"column2\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"column3\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "        },\n" +
            "        \"is_delete\": {\n" +
            "            \"type\": \"integer\"\n" +
            "        }\n" +
            "    }\n" +
            "}";
}
