package com.alex.webshop.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /**
     * This configuration will not require authentication for any API routes, which is easier during development.
     */
    @Configuration
    public static class DevSecurityConfig extends WebSecurityConfigurerAdapter {

        private static final Logger log = LoggerFactory.getLogger(DevSecurityConfig.class);

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            log.info("Spring Security development configuration loaded.");
            http
                    .csrf().disable()
                    .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
                    .authorizeRequests()
                    .antMatchers("/**").permitAll() // Simply permit all operations in development mode, may be changed later to something more restrictive if needed (added as part of #147).
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        }
    }
}
