package com.casestudy.happy_paws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//Sử dụng thuật toán Bcrypt để mã hóa password.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //Khi tạo mới tài khoản thì cần mã hóa mật khẩu trước khi lưu vào DB
//        String password = bCryptPasswordEncoder.encode("123123");
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll();


        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/account/login").permitAll();

        http.authorizeRequests()
                .antMatchers("/customer")
                .access("hasAnyRole('CUSTOMER', 'ADMIN')");

        http.authorizeRequests()
                .antMatchers("*", "/customer/*")
                .access("hasRole('ADMIN')");
        http.authorizeRequests()
                .antMatchers("/customer/", "/customer/")
                .access("hasRole('CUSTOMER')");
        http.authorizeRequests()
                .antMatchers("/account/", "/account/")
                .access("hasAnyRole('CUSTOMER','ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/customers/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/account/security") // Submit URL
                .loginPage("/account/login")//
                .defaultSuccessUrl("/customer")//
                .failureUrl("/account/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")

                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/account/logout").logoutSuccessUrl("/account/logoutSuccessful");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}