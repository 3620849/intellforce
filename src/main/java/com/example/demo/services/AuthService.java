package com.example.demo.services;

import com.example.demo.configurations.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Component
public class AuthService {
    public final String AUTH_HEADER_NAME="X-Auth";
    @Autowired
    HeaderHandler headerHandler;
    @Autowired
    UserService userService;

    public Optional<Authentication> getAuthentication (HttpServletRequest servletRequest){
        return Optional.ofNullable(servletRequest.getHeader(AUTH_HEADER_NAME))
                .flatMap(headerHandler::extractUserName)
                .map(UserAuth::new);

    }
}
