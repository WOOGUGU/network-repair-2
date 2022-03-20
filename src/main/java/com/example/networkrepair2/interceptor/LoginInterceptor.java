package com.example.networkrepair2.interceptor;

import com.example.networkrepair2.anno.NoNeedLogin;
import com.example.networkrepair2.util.TokenUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WOOGUGU
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //是不是映射到方法上
        boolean isHandlerMethod = handler instanceof HandlerMethod;
        if (!isHandlerMethod) {
            log.warn("不是方法上");
            return true;
        }
        //不需要登录的注解
        boolean isNoNeedLogin = ((HandlerMethod) handler).getMethodAnnotation(NoNeedLogin.class) != null;
        if (isNoNeedLogin) {
            log.warn("无需登录");
            return true;
        }
        //需要登录验证
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.error("无token");
        } else {
            Claims claims = null;
            try {
                claims = TokenUtil.parseJwt(token);
            } catch (Exception e) {
                log.error("token有误");
            }
            if (claims != null) {
                return true;
//                Integer id = Integer.valueOf(claims.getId());
//                String subject=claims.getSubject();
//                if(subject.equals(LoginService.TYPE_ZU_KE)){
//                    ZuKe zuKe = zuKeService.getById(id);
//                    if(zuKe!=null){
//                        request.setAttribute(LoginService.TYPE_ZU_KE,zuKe);
//                        return true;
//                    }
//                }else if (subject.equals(LoginService.TYPE_FANG_DONG)){
//                    FangDong fangDong =fangDongService.getById(id);
//                    if (fangDong!=null){
//                        request.setAttribute(LoginService.TYPE_FANG_DONG,fangDong);
//                        return true;
//                    }
//                }
//                return false;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
