package uz.edu.springsecuritydbproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @project: Spring-Security-DB-Project
 * @Date: 12.11.2022
 * @author: H_Urunov
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    //
    @Autowired
    private UserDetailsService userDetailsService; // Default security

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); //spring security
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest()
                .permitAll()
                .antMatchers("/home")
                .hasAuthority("USER")
                .antMatchers("/admin")
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
// https://bcrypt.online/
//https://bcrypt-generator.com/