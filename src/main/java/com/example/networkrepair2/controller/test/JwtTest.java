package com.example.networkrepair2.controller.test;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.networkrepair2.pojo.AdministratorList;
import com.example.networkrepair2.service.AdministratorListService;
import com.example.networkrepair2.util.JwtUtils;
import com.example.networkrepair2.util.ResponseCode;
import com.example.networkrepair2.util.ResultCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WOOGUGU
 */

@RestController
public class JwtTest {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AdministratorListService administratorListService;

    /**
     * 生成jwt信息
     */
    @PostMapping("/jwt/login")
    public Object login(
            @RequestParam(value = "jobNumber") Long jobNumber,
            @RequestParam(value = "password") String password
    ) {
        if (jobNumber == null || "".equals(password)) {
            // 参数丢失
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }

        AdministratorList administratorList = administratorListService.getBYId(jobNumber);
        if (administratorList == null) {
            return ResultCode.getJson(ResponseCode.IndexLost.value, "0", "用户不存在");
        } else if (!administratorList.getAdministratorPassword().equals(password)) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "密码错误");
        } else {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("AdministratorNumber", administratorList.getAdministratorNumber());
            dataMap.put("AdministratorName", administratorList.getAdministratorName());
            //生成token并存入数据返回
            String token = jwtUtils.createJwt(
                    administratorList.getAdministratorNumber().toString(),
                    administratorList.getAdministratorName(),
                    dataMap
            );
            return ResultCode.getJson(token, "登陆成功");
        }
    }

    /**
     * 从请求头信息中获取token数据
     * <p>1.获取请求头信息：名称=Authorization(前后端约定)
     * <p>2.解析token
     * <p>3.获取clamis
     */
    @PostMapping("/jwt/profile")
    public Object profile(
            @RequestHeader("Authorization") String authorization
    ) {
        if (StringUtils.isEmpty(authorization)) {
            //系统未捕捉到请求头信息
            return ResultCode.getJson("错误！，无请求头");
        }
        //2.解析token
        Claims claims = jwtUtils.parseJwt(authorization);
        //3.获取clamis
        String userId = claims.getId();
        String userName = claims.getSubject();
        AdministratorList administratorList = new AdministratorList();
        administratorList.setAdministratorNumber(Long.valueOf(String.valueOf(claims.get("AdministratorNumber"))));
        administratorList.setAdministratorName(String.valueOf(claims.get("AdministratorName")));


        return ResultCode.getJson(administratorList);
    }
}