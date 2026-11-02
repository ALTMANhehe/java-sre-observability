package com.example.sredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@RestController
public class SreDemoApplication {

    private final Counter visitCounter;

    public SreDemoApplication(MeterRegistry registry) {
        this.visitCounter = Counter.builder("app_visits_total")
                .description("Total number of visits to the hello endpoint")
                .register(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(SreDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        visitCounter.increment();
        return "Hello, SRE! You are visitor number " + visitCounter.count() + "!\n";
    }
}
