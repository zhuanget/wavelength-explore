package com.zhuanget.wavelengthexplore.processor;

import com.zhuanget.wavelengthexplore.constant.CrawlConst;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Zhuang_ET
 * @since 2020-12-31 17:35:39
 */
@Slf4j
public class NistProcessor implements PageProcessor {

    private Site site = Site.me().setRetrySleepTime(1000).setRetryTimes(3);

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        log.info("baseUrl: {}", url);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new SimpleBookProcessor())
                .addUrl(CrawlConst.DATABASE_URL)
//                .addPipeline(new ESPipeline())
//                .addPipeline(new DownloadImagePipeline())
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5)
                .run();
    }
}
