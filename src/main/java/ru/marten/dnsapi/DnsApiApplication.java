package ru.marten.dnsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DnsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DnsApiApplication.class, args);
    }
}
