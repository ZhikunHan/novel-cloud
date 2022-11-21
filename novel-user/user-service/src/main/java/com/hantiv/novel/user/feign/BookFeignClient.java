package com.hantiv.novel.user.feign;

import com.hantiv.novel.book.api.BookApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小说服务Feign客户端
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
@FeignClient("book-service")
public interface BookFeignClient extends BookApi {

}
