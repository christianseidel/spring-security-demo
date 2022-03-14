package de.neuefische.securitydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("seidel")
                .password("christian").roles("ADMIN")
                .and()
                .withUser("Mustermann").roles("USER")
                .password("Max")
                .and()
                .withUser("Musterfrau")
                .password("Gabi").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/api/greet").hasAnyRole("USER", "ADMIN")
                .and()
                .authorizeRequests()
                .mvcMatchers("/api/admingreet").hasRole("ADMIN")
                .and().authorizeRequests()
                .antMatchers("/**").authenticated()
                .and().formLogin()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
