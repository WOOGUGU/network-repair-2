package com.example.networkrepair2.controller.test;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.networkrepair2.anno.NoNeedLogin;
import com.example.networkrepair2.pojo.AdministratorList;
import com.example.networkrepair2.service.AdministratorListService;
import com.example.networkrepair2.util.JwtUtils;
import com.example.networkrepair2.util.ResponseCode;
import com.example.networkrepair2.util.ResultCode;
import com.example.networkrepair2.util.TokenUtil;
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
    AdministratorListService administratorListService;

    /**
     * 生成Token-新
     *
     * @param jobNumber 用户工号
     * @param password  密码
     * @return 基本信息+Token
     */
    @NoNeedLogin
    @PostMapping("/createJwtToken")
    public Object createJwtToken(
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
            dataMap.put("Token", TokenUtil.createJwtToken(jobNumber.toString(), administratorList.getAdministratorName()));
            return ResultCode.getJson(dataMap, "登陆成功");
        }
    }

    @PostMapping("/parseJwt")
    public Object parseJwt(
            @RequestHeader("Authorization") String authorization
    ) {
        if (StringUtils.isEmpty(authorization)) {
            return ResultCode.getJson("错误！，无请求头");
        }
        //解析token
        Claims claims = TokenUtil.parseJwt(authorization);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuer());
        return ResultCode.getJson(claims, "解析Token成功");
    }
}