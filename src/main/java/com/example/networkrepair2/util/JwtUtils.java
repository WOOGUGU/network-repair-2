package com.example.networkrepair2.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

/**
 * @author Mr.Yang
 **/

@Data
@Configuration
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    /**
     * 签名私钥
     */
    private String key;
    /**
     * 签名失效时间
     */
    private Long failureTime;

    /**
     * 设置认证token
     *
     * @param id      用户登录ID
     * @param subject 用户登录名
     * @param map     其他私有数据
     * @return token
     */
    public String createJwt(String id, String subject, Map<String, Object> map) {

        //1、设置失效时间（毫秒）
        long now = System.currentTimeMillis();
        long exp = now + failureTime;

        //2、创建JwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(new Date())
                //设置签名防止篡改
                .signWith(SignatureAlgorithm.HS256, key);

        //3、根据map设置claims
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(exp));

        //4、创建token
        return jwtBuilder.compact();
    }

    /**
     * 解析token
     *
     * @param token token
     * @return claims
     */
    public Claims parseJwt(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}