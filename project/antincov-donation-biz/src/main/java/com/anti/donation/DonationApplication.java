package com.anti.donation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@WebFilter(urlPatterns = "/login/*",filterName = "loginFilter")
public class DonationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }

}