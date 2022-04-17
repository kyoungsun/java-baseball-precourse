package baseball.view;

import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashSet;
import java.util.Objects;

public class BaseballGameConsole {
    private static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_ERROR_MESSAGE = "1 ~ 9 까지 숫자 중 중복되지 않는 숫자로 3자리를 입력해주세요.";

    public static LinkedHashSet<Integer> getUserInput() {
        System.out.print(INPUT_REQUEST_MESSAGE);
        String input = Console.readLine();
        LinkedHashSet<Integer> numbers = parserUserInput(input);
        validateNumbers(numbers);
        return numbers;
    }

    private static LinkedHashSet<Integer> parserUserInput(String input) {
        char[] chars = input.toCharArray();
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        for (char c : chars) {
            numbers.add(parserInt(c));
        }
        return numbers;
    }

    private static int parserInt(char c) {
        try {
            return Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateNumbers(LinkedHashSet<Integer> numbers) {
        if (!Objects.equals(numbers.size(), BaseballNumbers.NUMBERS_SIZE)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

}
