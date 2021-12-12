package vendingmachine.Model;

import vendingmachine.Constant.Constant;

import java.util.List;

public class Drink {
    private String name;
    private int price;
    private int stock;

    public Drink(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int isSameDrink(String drinkName) {
        if (drinkName.equals(name)) {
            return Constant.TRUE;
        }
        return Constant.FALSE;
    }

    public void subtractStock() {
        stock--;
    }

    public int isEmpty() {
        if (isSoldOut()) {
            return Constant.TRUE;
        } else return Constant.FALSE;
    }

    public boolean isSoldOut() {
        return (stock == Constant.ZERO);
    }

    public int isPaid(int inputMoney) {
        return inputMoney - price;
    }

    public boolean isCheaperThan(int comparedPrice) {
        if (price < comparedPrice) {
            return true;
        }
        return false;
    }

    public List<String> addNameToList(List<String> drinkNames) {
        drinkNames.add(name);
        return drinkNames;
    }
}
