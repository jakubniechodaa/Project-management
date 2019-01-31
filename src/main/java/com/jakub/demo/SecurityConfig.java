package com.jakub.demo;

import com.jakub.demo.components.AuthenticationSuccessHandlerImpl;
import com.jakub.demo.services.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandlerImpl(){
        return new AuthenticationSuccessHandlerImpl();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and().formLogin().successHandler(authenticationSuccessHandlerImpl())
                .loginPage("/login/")
                .permitAll()
                .usernameParameter("username").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login/signedout")
                .and().exceptionHandling().accessDeniedPage("/login/403");


        http.csrf().disable();
    }

}
