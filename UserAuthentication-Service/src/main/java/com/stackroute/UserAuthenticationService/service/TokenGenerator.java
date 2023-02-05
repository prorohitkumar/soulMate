package com.stackroute.UserAuthenticationService.service;

import com.stackroute.UserAuthenticationService.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Rohit
 * @Date 30-Oct-21 9:44 AM
 */
@Slf4j
public class TokenGenerator {
    /*Method that accepts validated User and returns a generated jwt token */
    public static String generateToken(User user){
        log.debug("Inside generate token");
        //TODO generate jwt token
        String jwtToken= Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        Map<String,String> map=new HashMap<String,String>();
        map.put("token",jwtToken);
        map.put("message","sucessfully loged in");
        return map;
    }
}
