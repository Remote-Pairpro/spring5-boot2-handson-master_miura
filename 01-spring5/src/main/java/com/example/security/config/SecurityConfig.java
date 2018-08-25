package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@ComponentScan(basePackages = "com.example.security.details")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 「/css/**」をセキュリティの除外対象にする
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/css/**");
    }
    
    // 認証認可設定を記述する
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login")
            .permitAll();
        http.authorizeRequests()
            .mvcMatchers("/insert*").hasRole("ADMIN")
            .anyRequest().authenticated();
        http.logout()
            .invalidateHttpSession(true)
            .permitAll();
    }

    // TODO 4-07 Beanであることを示すアノテーションを付加する

    public PasswordEncoder passwordEncoder() {
        // TODO 4-08 BCryptPasswordEncoderをnewしてreturnする
        return null;
    }
}
