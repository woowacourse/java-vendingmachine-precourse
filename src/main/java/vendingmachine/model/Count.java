package vendingmachine.model;

public class Count {

    private final int count;

    public Count(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int minusCount(int count) {
        return count - 1;
    }

    public boolean isCountValidation() {
        return minusCount(this.count) >= 0;
    }

}
