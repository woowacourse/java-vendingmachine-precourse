package vendingmachine.repository;

public class Money {
    private int remainder;

    public Money(int remainder) {
        this.remainder = remainder;
    }


    public int getRemainder() {
        return this.remainder;
    }

}
