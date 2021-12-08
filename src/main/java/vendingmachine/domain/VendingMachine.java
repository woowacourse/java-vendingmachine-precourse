package vendingmachine.domain;

import java.util.ArrayList;

public class VendingMachine {
    MachineMoney machineMoney;
    CoinList coinList;

    public void setMachineMoney(String money) throws IllegalArgumentException {
        machineMoney = new MachineMoney(money);
        coinList = new CoinList();
    }

    public void makeRandomCoin() {
        coinList.makeRandomCoinList(machineMoney.getMoney());
    }

    public ArrayList<Integer> getCoinCount() {
        return coinList.getCoinCount();
    }
}
