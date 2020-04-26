package org.heroesunlimited;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class HeroesUnlimitedApplication {
    public static void main(String[] args) {
        LOGGER.fine("Running App");
        ApplicationContext ctx = SpringApplication.run(HeroesUnlimitedApplication.class, args);
    }

    private static final Logger LOGGER = Logger.getLogger(HeroesUnlimitedApplication.class.getName());
}
