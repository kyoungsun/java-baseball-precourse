package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

import static baseball.domain.BaseballNumbers.*;

public class RandomBaseballNumbersGenerator {

    public BaseballNumbers generate() {
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        do {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        } while (numbers.size() < NUMBERS_SIZE);

        return new BaseballNumbers(numbers);
    }

}
