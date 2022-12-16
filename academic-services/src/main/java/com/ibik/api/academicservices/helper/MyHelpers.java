package com.ibik.api.academicservices.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class MyHelpers {
    public String PRIVATE_KEY = "ib1k_kec3";
    public Map DecodeJWT(String bearer_token){
        Map<String, Object> response = new HashMap<>();
        try {
            List<String> splitAuth = Arrays.asList(bearer_token.split(" "));
            String token = splitAuth.get(1);
            System.out.println(token);
            DecodedJWT decodedJWT;
            Algorithm algorithm = Algorithm.HMAC256(PRIVATE_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            decodedJWT = verifier.verify(token);
            response.put("data", decodedJWT);
            response.put("result", true);
        } catch (JWTVerificationException e) {
            response.put("message", e.getMessage());
            response.put("result", false);
            response.put("data", null);
        }
        return response;
    }
}
