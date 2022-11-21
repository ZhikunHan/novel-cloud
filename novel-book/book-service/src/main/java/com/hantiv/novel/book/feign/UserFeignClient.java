package com.hantiv.novel.book.feign;

import com.hantiv.novel.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户服务Feign客户端
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/28
 */
@FeignClient("user-service")
public interface UserFeignClient extends UserApi {

}
