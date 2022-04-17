package baseball.domain;

public class MatchingResult {
    private final int strikes;
    private final int balls;

    public MatchingResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isThreeStrikes() {
        return strikes == 3 && balls == 0;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

}
