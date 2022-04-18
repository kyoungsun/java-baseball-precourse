package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.domain.MatchingResult;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class BaseballGameConsole {
    private static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_ERROR_MESSAGE = "1 ~ 9 까지 숫자 중 중복되지 않는 숫자로 3자리를 입력해주세요.";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_REPLAY_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String REPLAY_GAME = "1";
    private static final String GAME_OVER = "2";

    public List<Integer> getUserInput() {
        System.out.print(INPUT_REQUEST_MESSAGE);
        String input = Console.readLine();
        LinkedHashSet<Integer> numbers = parserUserInput(input);
        validateNumbers(numbers);
        return new ArrayList<>(numbers);
    }

    private LinkedHashSet<Integer> parserUserInput(String input) {
        char[] chars = input.toCharArray();
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        for (char c : chars) {
            numbers.add(parserInt(c));
        }
        return numbers;
    }

    private int parserInt(char c) {
        try {
            return Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validateNumbers(LinkedHashSet<Integer> numbers) {
        if (!Objects.equals(numbers.size(), BaseballNumbers.NUMBERS_SIZE)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public void printMatchingResult(MatchingResult matchingResult) {
        if (matchingResult.isNothing()) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(createResultMessage(matchingResult));
    }

    private String createResultMessage(MatchingResult matchingResult) {
        StringBuffer sb = new StringBuffer();
        addBalls(matchingResult, sb);
        addStrikes(matchingResult, sb);

        return sb.toString().trim();
    }

    private void addBalls(MatchingResult matchingResult, StringBuffer sb) {
        if (matchingResult.getBalls() != 0) {
            sb.append(String.format("%d볼 ", matchingResult.getBalls()));
        }
    }

    private void addStrikes(MatchingResult matchingResult, StringBuffer sb) {
        if (matchingResult.getStrikes() != 0) {
            sb.append(String.format("%d스트라이크", matchingResult.getStrikes()));
        }
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public boolean askReplayGame() {
        System.out.println(ASK_REPLAY_GAME);
        String input = Console.readLine();
        validateUserInput(input);
        return Objects.equals(input, REPLAY_GAME);
    }

    private void validateUserInput(String input) {
        if (!Objects.equals(input, REPLAY_GAME) && !Objects.equals(input, GAME_OVER)) {
            throw new IllegalArgumentException();
        }
    }

}
