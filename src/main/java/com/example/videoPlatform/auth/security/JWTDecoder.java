package com.example.videoPlatform.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JWTDecoder {
    public DecodedJWT decode(String token) {
        //TODO hardcoded, needs fixation
        return JWT.require(Algorithm.HMAC256("secret"))
                .build()
                .verify(token);
    }
}
