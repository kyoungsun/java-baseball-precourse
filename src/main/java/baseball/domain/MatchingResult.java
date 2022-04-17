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

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        StringBuffer sb = new StringBuffer();
        if (strikes != 0) {
            sb.append(String.format("%d스트라이크 ", strikes));
        }

        if (balls != 0) {
            sb.append(String.format("%d볼", balls));
        }

        return sb.toString().trim();
    }
}
