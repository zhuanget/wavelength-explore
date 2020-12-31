package com.zhuanget.wavelengthexplore.processor;

import com.zhuanget.wavelengthexplore.constant.SimpleBookCrawlConst;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleBookProcessor implements PageProcessor {

    private Site site = Site.me().setRetrySleepTime(1000).setRetryTimes(3);
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex(SimpleBookCrawlConst.ARTICLE_URL).all());
        if (page.getUrl().get().equals(SimpleBookCrawlConst.BASE_URL)) {
            List<String> titleList = page.getHtml().xpath("//*[@class='title']/@href").all();
            List<String> fullTitleList = new ArrayList<>(titleList.size());
            for (String titleUrl : titleList) {
                fullTitleList.add(SimpleBookCrawlConst.BASE_URL + titleUrl);
            }
            page.addTargetRequests(fullTitleList);
            //load-more
//            page.addTargetRequest(SimpleBookCrawlConst.BASE_URL);
            page.setSkip(true);
        }else if (page.getUrl().regex(SimpleBookCrawlConst.ARTICLE_URL).match()) {
            page.putField(SimpleBookCrawlConst.USER_HOME, page.getUrl().get());
            page.putField(SimpleBookCrawlConst.TITLE, page.getHtml().xpath("//*[@class='_1RuRku']/text()").toString());
            page.putField(SimpleBookCrawlConst.USER, page.getHtml().xpath("//*[@class='_22gUMi']/text()").toString());

            Selectable xpath = page.getHtml().xpath("//*[@property='og:image']/@content");
            page.putField(SimpleBookCrawlConst.IMAGE_URL, xpath.toString());
            List<String> imgList = page.getHtml().xpath("//*[@class=\"image-view\"]/img/@data-original-src").all();
            List<String> realImgList = new ArrayList<>(imgList.size());
            for (String imgUrl : imgList) {
                realImgList.add("https:" + imgUrl);
            }
            page.putField("imageUrls", realImgList);
        }else {
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new SimpleBookProcessor())
                .addUrl(SimpleBookCrawlConst.BASE_URL)
//                .addPipeline(new ESPipeline())
//                .addPipeline(new DownloadImagePipeline())
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(5)
                .run();
    }
}
