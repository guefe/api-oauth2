package com.cen.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;




@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private String[] entryPoints = {
                "/v2/api-docs/","/configuration/**", "/swagger**", "/webjars/**", "/v2/api-docs/**", "/h2/**"
            };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(entryPoints).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable().addFilterAfter(new SimpleCorsFilter(), BasicAuthenticationFilter.class);
    }


}
