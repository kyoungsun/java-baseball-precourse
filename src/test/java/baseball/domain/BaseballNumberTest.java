package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    @Test
    void testThreeStrikes() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new LinkedHashSet<>(Arrays.asList(1,2,3)));
        MatchingResult matching = baseballNumbers.matching(Arrays.asList(1,2,3));
        assertThat(matching.isThreeStrikes()).isTrue();
    }

    @Test
    void testThreeBalls() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new LinkedHashSet<>(Arrays.asList(1,2,3)));
        MatchingResult matching = baseballNumbers.matching(Arrays.asList(2,3,1));
        assertThat(matching.getStrikes()).isEqualTo(0);
        assertThat(matching.getBalls()).isEqualTo(3);
    }

    @Test
    void testIsNothing() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(new LinkedHashSet<>(Arrays.asList(1,2,3)));
        MatchingResult matching = baseballNumbers.matching(Arrays.asList(4,5,6));
        assertThat(matching.isNothing()).isEqualTo(true);
    }

}
