package vendingmachine.menu;

import vendingmachine.exception.VendingMachineException;

public class Menu {
    private final String name;
    private final int price;

    private Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Menu of(String menuName, int price){
        validatePrice(price);
        return new Menu(menuName, price);
    }

    private static void validatePrice(int price) {
        if(price < 100 || price % 10 != 0){
            throw VendingMachineException.INVALID_MONEY_VALUE.makeException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
