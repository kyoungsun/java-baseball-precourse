package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.MatchingResult;
import baseball.domain.RandomBaseballNumbersGenerator;
import baseball.view.BaseballGameConsole;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballNumbers answerNumbers = RandomBaseballNumbersGenerator.generate();
        System.out.println(answerNumbers.getNumbers());
        while (true) {
            MatchingResult matchingResult = answerNumbers.matching(new ArrayList<>(BaseballGameConsole.getUserInput()));
            if (matchingResult.isThreeStrikes()) {
                System.out.println(matchingResult);
                break;
            }
            System.out.println(matchingResult);
        }
    }

}
