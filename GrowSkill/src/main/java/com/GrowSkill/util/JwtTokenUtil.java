package com.GrowSkill.util;

import com.GrowSkill.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private static long jwtExpirationMs = 0;
    private static final String secret = "NyHnbBw84RGC6sO565pVriPWqNaw0dc4DVbzigpnoMBAFi6cbU/xsGniO1eLUjOJU9hA8wLzHsw1/gRmkIDHMlgnP7F+RQxMBt/6cawr3x+YvzAhn3ZFEWzcuD/3dV8aykV09qd99zQ3Z13uwUjlo8odhklvOK99aA5fMasBL1aJHfE3xhEwH27ytgHWm1LsBFGz8A7LJAWwKDQIShc4WnqJbhQ4URHZoqpDXm5orDOhO41vEkTWQrKSXcf3zr7Rmi1Buw7t0TeTaMpganpWtQQEM3iitKXEB/yLj4Z+NLvcA3PmLHbNColC4MOTHW2LrcKAfsN9uoq9BP4abjEA/IvKWihyydLPy1GcsemWO4I=";

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(UserDetails userDetails, String abc) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("school", abc);
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String generateToken(User user, String schoolUid) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, user.getUserName());
    }

}
