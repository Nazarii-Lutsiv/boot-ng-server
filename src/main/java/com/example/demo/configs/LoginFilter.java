package com.example.demo.configs;


import com.example.demo.models.AccountCredentials;
import com.example.demo.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }


// During the authentication attempt,
// which is dealt by the attemptAuthentication method,
// we retrieve the username and password from the request.
// After they are retrieved, we use the AuthenticationManager to verify that these details match with an existing user.
// If it does, we enter the successfulAuthentication method.
// In this method we fetch the name from the authenticated user,
// and pass it on to TokenAuthenticationService, which will then add a JWT to the response.

    private User creds;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException{
        //this method react  on /login url  and retrive body from request
        //then map it to model AccountCredential
        creds = new ObjectMapper()
                .readValue(httpServletRequest.getInputStream(), User.class);

        System.out.println(creds.getUsername());
        // then  get default method getAuthenticationManager()
        // and set Authentication object based on data from creds object

        // if auth process if success we jump to line 65 successfulAuthentication()

        //find in database or in memory your object parse at and add it as outh object
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword(),
                        creds.getAuthorities()
                )
        );


    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        String jwtoken = Jwts.builder()
                .setSubject(auth.getName())
                .signWith(SignatureAlgorithm.HS512, "yes".getBytes())
//                .setExpiration(new Date(System.currentTimeMillis() + 200000))
                .compact();
        //and add it to header
        res.addHeader("Authorization", "Bearer " + jwtoken);
//        System.out.println(res.toString()+ "      "  + jwtoken);
    }
}

