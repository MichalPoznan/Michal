package io.github.mat3e;

import java.util.Optional;

class HelloService {
    private static final String FALLBACK_NAME = "world";

    String prepareGreetings(String name) {
        return "Hello " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
    }
}
