package vendingmachine;

import vendingmachine.exception.VendingMachineException;
import vendingmachine.menu.Menu;

public class Credit {
    private int money;

    public Credit(int money){
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(money < 100 || money % 10 != 0){
            throw VendingMachineException.INVALID_MONEY_VALUE.makeException();
        }
    }


    public boolean canPurchase(int price){
        return money >= price;
    }

    public void purchase(Menu menu){
        if(menu.getPrice() > money){
            throw VendingMachineException.CANT_PURCHASE.makeException();
        }
        money -= menu.getPrice();
    }

    public int getMoney() {
        return money;
    }
}
