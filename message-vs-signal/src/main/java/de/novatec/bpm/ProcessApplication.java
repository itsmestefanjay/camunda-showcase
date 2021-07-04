package de.novatec.bpm;

import de.novatec.bpm.config.ApplicationConfig;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableProcessApplication("processApplication")
@Import(ApplicationConfig.class)
public class ProcessApplication {
    public static void main(final String... args) {
        SpringApplication.run(ProcessApplication.class, args);
    }
}
