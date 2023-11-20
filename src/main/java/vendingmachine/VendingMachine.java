package vendingmachine;

import java.util.Map;
import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;
import vendingmachine.menu.Menu;
import vendingmachine.menu.Menus;

public class VendingMachine {
    private final Menus menus;
    private final Credit credit;
    private final Coins coins;

    public VendingMachine(Menus menus, Credit credit, Coins coins) {
        this.menus = menus;
        this.credit = credit;
        this.coins = coins;
    }

    public boolean isSellable(){
        if(menus.isSoldOut()){
            return false;
        }
        int minPrice = menus.getMinPrice();
        return credit.canPurchase(minPrice);
    }

    public int getRemainMoney(){
        return credit.getMoney();
    }

    public void purchase(String menuName){
        Menu menu = menus.getMenu(menuName);
        credit.purchase(menu);
        menus.purchase(menu);
    }

    public Map<Coin, Integer> giveChange(){
        return coins.giveChange(credit.getMoney());
    }
}
