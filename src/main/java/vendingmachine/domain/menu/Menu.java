package vendingmachine.domain.menu;

import java.util.Objects;
import vendingmachine.domain.money.Cash;
import vendingmachine.domain.money.Money;
import vendingmachine.exception.VendingMachineException;

public class Menu {
    public static final int MIN_PRICE = 100;
    public static final int PRICE_UNIT = 10;
    private final String name;
    private final Money price;
    private int amount;

    private Menu(String name, int price, int amount) {
        validateName(name);
        validatePrice(price);
        validateAmount(amount);

        this.name = name;
        this.price = new Money(price);
        this.amount = amount;
    }

    //[글자,숫자,숫자] 형태의 입력이 보장
    public static Menu from(String menuInput) {
        String[] menuInfo = menuInput
                .replaceAll("[\\[\\]]", "")
                .split(",");
        return new Menu(menuInfo[0],
                Integer.parseInt(menuInfo[1]),
                Integer.parseInt(menuInfo[2]));
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw VendingMachineException.MENU_NAME_BLANK.makeException();
        }
    }

    private void validateAmount(int amount) {
        if (amount < 1) {
            throw VendingMachineException.MENU_AMOUNT_MUST_POSITIVE.makeException();
        }
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw VendingMachineException.MONEY_MUST_NOT_NEGATIVE.makeException();
        }
        if (price < MIN_PRICE) {
            throw VendingMachineException.PRICE_SMALL_THAN_MIN.makeException(MIN_PRICE);
        }
        if (price % PRICE_UNIT != 0) {
            throw VendingMachineException.INVALID_MONEY_UNIT.makeException(PRICE_UNIT);
        }
    }

    public boolean canPurchase(Cash cash) {
        if (soldOut()) {
            return false;
        }
        return cash.canPurchase(this.price);
    }

    public void purchase(Cash cash) {
        if (soldOut()) {
            throw VendingMachineException.SOLD_OUT_MENU.makeException();
        }
        cash.spend(this.price);
        this.amount--;
    }

    private boolean soldOut() {
        return this.amount == 0;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
