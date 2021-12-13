package vendingmachine.model;

public class Count {

    private int count;

    public Count(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void minusCount() {
        this.count--;
    }

    public boolean isCountValidation() {
        return this.count > 0;
    }

}
