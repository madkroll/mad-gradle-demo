package com.madkroll.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class GameApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }
}