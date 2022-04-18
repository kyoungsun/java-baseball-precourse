package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.RandomBaseballNumbersGenerator;
import baseball.view.BaseballGameConsole;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameConsole console = new BaseballGameConsole();
        RandomBaseballNumbersGenerator generator = new RandomBaseballNumbersGenerator();
        BaseballGameController controller = new BaseballGameController(console, generator);
        controller.startGame();
    }

}
