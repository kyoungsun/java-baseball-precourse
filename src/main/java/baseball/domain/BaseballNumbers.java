package baseball.domain;

import java.util.LinkedHashSet;

public class BaseballNumbers {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final LinkedHashSet<Integer> numbers;

    public BaseballNumbers(LinkedHashSet<Integer> numbers) {
        this.numbers = numbers;
    }

    public LinkedHashSet<Integer> getNumbers() {
        return numbers;
    }
}
