package com.cisco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.cisco.**", "org.kie.kogito.**", "http**"})
public class KogitoTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(KogitoTestApplication.class, args);
    }
}