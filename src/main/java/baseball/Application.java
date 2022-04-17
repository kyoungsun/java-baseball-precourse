package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.MatchingResult;
import baseball.domain.RandomBaseballNumbersGenerator;
import baseball.view.BaseballGameConsole;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            playGame();
        } while (BaseballGameConsole.askReplayGame());
    }

    public static void playGame() {
        BaseballNumbers answerNumbers = RandomBaseballNumbersGenerator.generate();
        System.out.println(answerNumbers.getNumbers());
        MatchingResult matchingResult;
        do {
            LinkedHashSet<Integer> userInput = BaseballGameConsole.getUserInput();
            List<Integer> numbers = new ArrayList<>(userInput);
            matchingResult = answerNumbers.matching(numbers);
            System.out.println(matchingResult.toString());
        } while (!matchingResult.isThreeStrikes());

        BaseballGameConsole.printGameEndMessage();
    }

}
