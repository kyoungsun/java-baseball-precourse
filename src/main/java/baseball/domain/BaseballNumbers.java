package baseball.domain;

import java.util.*;

public class BaseballNumbers {
    public static final int NUMBERS_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final List<Integer> numbers;

    public BaseballNumbers(LinkedHashSet<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public MatchingResult matching(List<Integer> numbers) {
        int strikes = 0;
        int balls = 0;
        final int loopCount = numbers.size();
        for (int i = 0; i < loopCount; i++) {
            Integer number = numbers.get(i);
            strikes += countStrike(number, i);
            balls += countBall(number, i);
        }
        return new MatchingResult(strikes, balls);
    }

    private int countStrike(int number, int indexOf) {
        return this.numbers.indexOf(number) == indexOf ? 1 : 0;
    }

    private int countBall(int number, int indexOf) {
        return (this.numbers.contains(number) && countStrike(number, indexOf) == 0)  ? 1 : 0;
    }

}
