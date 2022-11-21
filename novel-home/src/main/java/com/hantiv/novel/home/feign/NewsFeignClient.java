package com.hantiv.novel.home.feign;

import com.hantiv.novel.news.api.NewsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 新闻服务Feign客户端
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
@FeignClient("news-service")
public interface NewsFeignClient extends NewsApi {

}
