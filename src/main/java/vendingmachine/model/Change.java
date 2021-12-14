package vendingmachine.model;

import vendingmachine.util.constant.Symbol;

public class Change {
    private final Coin coin;
    private int number = 0;

    public Change(Coin coin) {
        this.coin = coin;
    }

    public Coin getCoin() {
        return coin;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return coin.getAmount() + Symbol.WON +
                Symbol.HYPHEN_SPACE +
                number + Symbol.COUNT;
    }

    public Change getReturnChange(int amount) {
        Change newChange = new Change(coin);
        int count = amount / coin.getAmount();

        if (number < count) {
            count = number;
        }
        newChange.addNumber(count);
        subNumber(count);
        return newChange;
    }

    public void increaseNumber() {
        number++;
    }

    private void addNumber(int number) {
        this.number += number;
    }

    private void subNumber(int number) {
        this.number -= number;
    }
}
