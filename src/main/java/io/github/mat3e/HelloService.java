package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

    HelloService(LangRepository repositry) {
        this.repository = repositry;
    }

    String prepareGreeting(String name, String langId) {
        Integer langIdNum;
        try {
            langIdNum = Optional.ofNullable(langId).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());
        } catch (NumberFormatException e) {
            logger.warn("Non-numeric language id used: " + langId);
            langIdNum = FALLBACK_LANG.getId();
            //e.printStackTrace();
        }
        var welcomeMsg = repository.findById(langIdNum).orElse(FALLBACK_LANG).getWelcomeMsg();
        return welcomeMsg + " " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
    }
}
