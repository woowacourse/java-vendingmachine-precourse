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
        count = this.count - 1;
        System.out.println("개수: " + count);
        return count;
    }

    public boolean isCountValidation() {
        return (this.count - 1) <= 0;
    }

}
