package com.yeseung.sgyjsecurityspringbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SgyjSecuritySpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgyjSecuritySpringBootStarterApplication.class, args);
    }

}
