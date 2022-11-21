package com.hantiv.novel.home.feign;

import com.hantiv.novel.book.api.BookApi;
import com.hantiv.novel.home.feign.fallback.BookFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小说服务Feign客户端
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */

@FeignClient(name = "book-service",fallback = BookFeignFallback.class)
public interface BookFeignClient extends BookApi {


}
