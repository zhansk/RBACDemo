package bspringsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/error.html");
        //http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
        http.formLogin()
                //自定义登陆页面
                .loginPage("/login.html")
                //自定义登陆逻辑
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/success.html").permitAll();


        http.authorizeRequests()
                .antMatchers("/","/test/hello","/user/login").permitAll()
                //所有请求都要认证
                .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder pw(){
        return new BCryptPasswordEncoder();
    }
}
