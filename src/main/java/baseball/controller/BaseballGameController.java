package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.MatchingResult;
import baseball.domain.RandomBaseballNumbersGenerator;
import baseball.view.BaseballGameConsole;

import java.util.List;

public class BaseballGameController {

    private final BaseballGameConsole console;
    private final RandomBaseballNumbersGenerator generator;

    public BaseballGameController(BaseballGameConsole console, RandomBaseballNumbersGenerator generator) {
        this.console = console;
        this.generator = generator;
    }

    public void startGame() {
        do {
            playGame();
        } while (console.askReplayGame());
    }

    public void playGame() {
        BaseballNumbers answerNumbers = generator.generate();
        MatchingResult matchingResult;
        do {
            List<Integer> numbers = console.getUserInput();
            matchingResult = answerNumbers.matching(numbers);
            console.printMatchingResult(matchingResult);
        } while (!matchingResult.isThreeStrikes());

        console.printGameEndMessage();
    }

}
