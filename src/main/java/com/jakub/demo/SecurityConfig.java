package com.jakub.demo;

import com.jakub.demo.services.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("USER"
                ,
                "ADMIN")
//                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and().formLogin()
                .loginPage("/users/signin")
                .usernameParameter("username").passwordParameter("password")
                .and().logout().logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/403")
        ;

//        http.csrf().disable();
    }

}

//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user1").password("user123").roles("USER")
////                .and()
////                .withUser("admin1").password("{noop}admin123").roles("ADMIN");
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("USER"
//                ,
//                "ADMIN")
//                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
//                .anyRequest().permitAll()
//                .and().formLogin()
//                .loginPage("/users/signin");
//    }
//
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsServiceImpl customUserDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//}