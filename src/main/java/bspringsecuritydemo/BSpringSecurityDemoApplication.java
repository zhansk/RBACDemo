package bspringsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@SpringBootApplication
public class BSpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BSpringSecurityDemoApplication.class, args);
    }

}
