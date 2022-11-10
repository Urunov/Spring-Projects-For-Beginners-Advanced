package uz.edu.biblatekaservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class BookSecurity extends WebSecurityConfigurerAdapter {
    //
    // Annotation
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("gfg")
                .password(passwordEncoder().encode("pass"))
                .roles("ADMIN")
                .and()
                .passwordEncoder(passwordEncoder())
                .withUser("user")
                .password(passwordEncoder().encode("pass"))
                .roles("BASIC");
    }

    // Annotation
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    // Annotation
    @Override
    protected void configure(HttpSecurity http)
            throws Exception
    {

        http.authorizeRequests()
                .antMatchers("/basic")
                .hasAnyRole("BASIC", "ADMIN")
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .usernameParameter("username")
                .and()
                .logout()
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout"))
                .permitAll();
    }
}
