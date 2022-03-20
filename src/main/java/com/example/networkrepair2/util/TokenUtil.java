package com.example.networkrepair2.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author Parsley
 * @date 2021/02/02/21:24
 */
public class TokenUtil {

    /**
     * 签名的密钥
     */
    public static final String SECRET = "nicaibudao233333";
    /**
     * 签发者
     */
    public static final String ISSUER = "hjj";
    /**
     * 面向的用户
     */
    public static final String SUBJECT = "user";
    /**
     * 签发时间
     */
    public static final Integer TTLMILLIS = 2 * 60 * 60 * 1000;


    /**
     * 生成token
     *
     * @param id userNumber
     * @return token String
     */
    public static String createJwtToken(String id) {
        return createJwtToken(id, ISSUER, SUBJECT, TTLMILLIS);
    }

    /**
     * @param id      userNumber
     * @param subject userName
     * @return token String
     */
    public static String createJwtToken(String id, String subject) {
        return createJwtToken(id, ISSUER, subject, TTLMILLIS);
    }

    /**
     * 生成Token
     *
     * @param id        编号
     * @param issuer    该JWT的签发者，是否使用是可选的
     * @param subject   该JWT所面向的用户，是否使用是可选的；
     * @param ttlMillis 签发时间 （有效时间，过期会报错）
     * @return token String
     */
    public static String createJwtToken(String id, String issuer, String subject, long ttlMillis) {

        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //签发当前时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //根据密钥生成密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Token建造器
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer).signWith(signatureAlgorithm, signingKey);

        //设置过期时间
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //压缩
        return builder.compact();
    }

    /**
     * 解析Token
     *
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET)).parseClaimsJws(jwt).getBody();
        return claims;
    }
}
