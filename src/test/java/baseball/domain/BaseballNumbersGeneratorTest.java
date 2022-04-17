package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersGeneratorTest {

    @DisplayName("3자리 숫자를 생성합니다.")
    @Test
    void testGenerate() {
        BaseballNumbers baseballNumbers = RandomBaseballNumbersGenerator.generate();
        assertThat(baseballNumbers.getNumbers().size()).isEqualTo(BaseballNumbers.NUMBERS_SIZE);
    }
}