package com.hantiv.novel.author.controller.api;

import com.hantiv.novel.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author Zhikun Han
 * @Date Created in 20:10 2022/11/12
 * @Description: 用户微服务API接口（内部调用）
 */
@RestController
@RequestMapping("api/author")
@RequiredArgsConstructor
@ApiIgnore
public class AuthorApi {

    private final AuthorService authorService;
}
