package io.github.mat3e;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");

    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

     HelloService(LangRepository repositry) {
        this.repository = repositry;
    }

    String prepareGreeting(String name, String langId) {
        var langIdNum = Optional.ofNullable(langId).map(Long::valueOf).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langIdNum).orElse(FALLBACK_LANG).getWelcomeMsg();
        return welcomeMsg + " " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
    }
}
