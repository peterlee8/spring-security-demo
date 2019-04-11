package com.limouren.springsecuritydemo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @Author peterLee
 * @CreateDate 2019/4/11
 */
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "echisan";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    // 添加角色的key
    private static final String ROLE_CLAIMS = "rol";

    /**
     * 生成token
     * @param username
     * @param isRememberMe
     * @return
     */
    public static String createToken(String username,String role,boolean isRememberMe){
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;

        HashMap<String,Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS,role);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)  // 这里要早set一点，放到后面会覆盖别的字段
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000))
                .compact();
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    /*public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }*/

    /**
     * java 8 写法
     * @param execute
     * @param token
     * @return
     */
    public static String getUserRole(Function<String,String> execute,String token){
        String apply = execute.apply(token);
        return (String) getTokenBody(apply).get(ROLE_CLAIMS);
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public static String getUserName(Function<String,String> execute,String token){
        return getTokenBody( execute.apply(token)).getSubject();
    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(Function<String,String> execute,String token){
        return getTokenBody(execute.apply(token)).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
