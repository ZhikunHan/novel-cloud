package com.hantiv.novel.common.base;

import com.hantiv.novel.common.bean.UserDetails;
import com.hantiv.novel.common.utils.CookieUtil;
import com.hantiv.novel.common.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础Controller
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
public class BaseController {

    protected JwtTokenUtil jwtTokenUtil;


    /**
     * 获取登陆token
     * */
    protected String getToken(HttpServletRequest request){
        String token = CookieUtil.getCookie(request,"Authorization");
        if(token != null){
            return token;
        }
        return request.getHeader("Authorization");
    }

    /**
     * 获取登陆用户信息
     * */
    protected UserDetails getUserDetails(HttpServletRequest request) {
        String token = getToken(request);
        if(StringUtils.isBlank(token)){
            return null;
        }else{
            return jwtTokenUtil.getUserDetailsFromToken(token);
        }
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
}
