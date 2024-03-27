package vendingmachine;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VendingMachine {
    private int currentChange;
    private int currentUsersMoney;
    private Coins coins;
    private Products products;

    public VendingMachine() {
        currentChange = 0;
        currentUsersMoney = 0;
    }

    public void inputInitialMoney() {
        this.currentChange = InputView.inputInitialMoney();
    }

    public void generateInitialCoins() {
        int remainingMoney = currentChange;

        int fiveHundredCount = Randoms.pickNumberInRange(0, remainingMoney/500);
        remainingMoney -= 500*fiveHundredCount;
        int hundredCount = Randoms.pickNumberInRange(0, remainingMoney/100);
        remainingMoney -= 100*hundredCount;
        int fiftyCount = Randoms.pickNumberInRange(0, remainingMoney/50);
        remainingMoney -= 50*fiftyCount;
        int tenCount = remainingMoney/10;

        Map<Coin, Integer> generatedCoins = new HashMap<>();
        generatedCoins.put(Coin.COIN_500, fiveHundredCount);
        generatedCoins.put(Coin.COIN_100, hundredCount);
        generatedCoins.put(Coin.COIN_50, fiftyCount);
        generatedCoins.put(Coin.COIN_10, tenCount);

        this.coins = new Coins(generatedCoins);

        OutputView.printCoins(coins);
    }

    public void inputProducts() {
        this.products = InputView.inputInitialProducts();
    }

    public void inputUsersMoney() {
        this.currentUsersMoney = InputView.inputUsersMoney();
    }

    public int getCurrentChange() {
        return this.currentChange;
    }

    public Coins getCoins() {
        return this.coins;
    }

    public Set<Product> getProducts() {
        return this.products.getProducts();
    }

    public int getCurrentUsersMoney() {
        return this.currentUsersMoney;
    }
}
