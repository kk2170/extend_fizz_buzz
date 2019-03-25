package parameter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTest {


    @ParameterizedTest(name = "{0} & {1} & {2}")
    @CsvSource({
            "'中華',  '2',   '1'",
            "'洋食',  '1',   '1'"
    })
    /**
     * 有効なパターンのテスト
     */
    void checkValidValue(String category, String x, String y) {
        String[] args = {category, x, y};
        Parameter parameter = new Parameter(args);

        parameter.checkAndSetValue();
        assertFalse(parameter.isInvalid());
    }

    @ParameterizedTest(name = "{0} & {1} & {2}")
    @CsvSource({
            "'中華',  '0',   '1'",
            "'洋食',  '-1',   '1'",
            "'中華',  '1',   '0'",
            "'洋食',  '1',   '-1'",
            "'洋食',  '1',   '-1'",
            "'洋食',  '洋食', '1'",
            "'中華',  '1',   '洋食'"
    })

    /**
     * 無効なパターンのテスト
     */
    void checkInvalidValue(String category, String x, String y) {
        String[] args = {category, x, y};
        Parameter parameter = new Parameter(args);

        parameter.checkAndSetValue();
        assertTrue(parameter.isInvalid());
    }

}