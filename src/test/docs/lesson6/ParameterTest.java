package docs.lesson6;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterTest {

    @DisplayName("CHECK")
    @ParameterizedTest(name="{0} {displayName} ")
    @ValueSource(strings = {"AAA", "BBB"})
    void testParameterization(String city) {
        Allure.parameter("City", city);

    }
}
