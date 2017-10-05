package com.example.demo.configurations;

import com.example.demo.services.AuthService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by UA C on 04.10.2017.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
    AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new AuthFilterForAngular(authService), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/lib/**","/js/**","/getToken","/*","/register/**").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Autowired
    UserService userService;
    @Autowired
    public void configureGolobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userService);

    }
}
