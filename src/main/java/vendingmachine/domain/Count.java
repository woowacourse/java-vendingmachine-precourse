package vendingmachine.domain;

public class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public boolean isZero() {
        return count == 0;
    }

    public void reduce() {
        validateZero(count);
        count--;
    }

    private void validateZero(int count) {
        if (count == 0) {
            throw new IllegalArgumentException("[ERROR] 이미 개수가 0입니다!");
        }
    }
}
