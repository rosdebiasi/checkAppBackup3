package com.checkapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests().antMatchers("/", "/javax.faces.resource/**", "/resources/**", "/inspecao**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and().logout().invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/")
                .and().oauth2Login().defaultSuccessUrl("/home.jr");

    }

}
