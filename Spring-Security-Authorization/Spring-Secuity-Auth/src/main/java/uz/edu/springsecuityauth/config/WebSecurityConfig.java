package uz.edu.springsecuityauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder.inMemoryAuthentication()
                    .withUser("oybek")
                    .password("oybek123")
                    .roles("ADMIN")
                    .and()
                    .withUser("sitora")
                    .password("sitora")
                    .roles("USER");
    }

    /***
     * Simple configuration of webSecurity
     *
     @Override
     public void configure(WebSecurity web) throws Exception {
     super.configure(web);
     }
    * */

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers("/**")
                .hasRole("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}