package io.github.mat3e;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    // private HelloService SUT = new HelloService(); //System Under Test
    private final static String WELCOME = "Hello";

    @Test
    public void test_prepareGreeting_nullName_returnsGreettingsWithFallbackName() {
/*      // given
        String name = null;
        // when
        var result = SUT.prepareGreeting(name);
    LUB // given + when
        var result = SUT.prepareGreeting(null);
*/
        // given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        //when
        var result = SUT.prepareGreeting(null, "-1");
        // then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingsWithName() {
        // given
        var SUT = new HelloService();
        var name = "test";

        // when
        var result = SUT.prepareGreeting(name, "-1");

        // then
        assertEquals(WELCOME + " " + name + "!", result);
    }

    private LangRepository alwaysReturningHelloRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }
}
