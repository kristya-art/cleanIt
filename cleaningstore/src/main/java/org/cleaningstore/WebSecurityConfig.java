package org.cleaningstore;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/customers").permitAll()
                .antMatchers(HttpMethod.POST,"/orders").permitAll()
                .antMatchers(HttpMethod.GET,"/orders").permitAll()
                .antMatchers(HttpMethod.GET,"customers").permitAll()
                .and().httpBasic()
                .and().csrf().disable();
    }
}
