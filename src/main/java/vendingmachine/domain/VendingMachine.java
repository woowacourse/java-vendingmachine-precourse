package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;
import vendingmachine.domain.money.Cash;
import vendingmachine.domain.money.Money;

public class VendingMachine {
    private final Coins coins;
    private final Menus menus;

    public VendingMachine(Coins coins, Menus menus) {
        this.coins = coins;
        this.menus = menus;
    }

    public boolean canPurchase(Cash cash) {
        return menus.canPurchase(cash);
    }

    public void purchase(String menuName, Cash cash) {
        menus.purchase(menuName, cash);
    }

    public EnumMap<Coin, Integer> returnCoin(Money remainMoney) {
        return coins.returnCoins(remainMoney);
    }
}
