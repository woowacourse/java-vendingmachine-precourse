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
        System.out.println("개수: " + this.count);
    }

    public boolean isCountValidation() {
        System.out.println(this.count);
        return (this.count) < 0;
    }

}
