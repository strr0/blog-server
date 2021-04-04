package com.example.demo.config;

import com.example.demo.common.CommonResult;
import com.example.demo.config.security.CustomUserDetails;
import com.example.demo.system.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.PrintWriter;

/**
 * SpringSecurity配置
 * @author STRR
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Lambda表达式, 根据用户名获取用户信息
        auth.userDetailsService(username -> service.loadUserByUsername(username))
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/home").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //Lambda表达式
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    //getPrincipal获取UserDetails
                    CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
                    CommonResult result = CommonResult.success(userDetails.getUser());
                    out.write(new ObjectMapper().writeValueAsString(result));
                    out.flush();
                    out.close();
                })
                //Lambda表达式
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    CommonResult result = CommonResult.fail();
                    out.write(new ObjectMapper().writeValueAsString(result));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                //Lambda表达式
                .logoutSuccessHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    CommonResult result = CommonResult.success();
                    out.write(new ObjectMapper().writeValueAsString(result));
                    out.flush();
                    out.close();
                }))
                .permitAll()
                .and()
                //跨域保护, 启用后post请求无法通过
                .csrf().disable()
                .exceptionHandling();
    }
}
