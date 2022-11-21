package com.hantiv.novel.author.feign;

import com.hantiv.novel.book.api.BookApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author Zhikun Han
 * @Date Created in 16:08 2022/11/13
 * @Description:
 */
@FeignClient("book-service")
public interface BookFeignClient extends BookApi {
}
