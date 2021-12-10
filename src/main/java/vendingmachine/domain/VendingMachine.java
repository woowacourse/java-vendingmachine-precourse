package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
    MachineMoney machineMoney;
    Coin coin;
    MerchandiseList merchandiseList;
    InputMoney inputMoney;

    public VendingMachine() {
        merchandiseList = new MerchandiseList();
    }

    public void setMachineMoney(String money) throws IllegalArgumentException {
        machineMoney = new MachineMoney(money);
    }

    public Coin getCoin() {
        return coin;
    }

    public void makeRandomAllCoin() {
        for (Coin c : coin.values()) {
            makeRandomCoin(c);
        }
    }

    private void makeRandomCoin(Coin coin) {
        if (coin == Coin.COIN_10) {
            coin.setCount(machineMoney.getMoney() / coin.getAmount());
            return;
        }
        int number = Randoms.pickNumberInRange(0, machineMoney.getMoney() / coin.getAmount());
        machineMoney.minusMoney(coin.getAmount() * number);
        coin.setCount(number);
    }

    public void addMerchandise(String merchandise) {
        merchandiseList.addAllMerchandise(merchandise);
    }

    public String getAllMerchandiseInfo() {
        return merchandiseList.getAllMerchandiseInfo();
    }

    public void setInputMoney(String inputMoney) {
        new InputMoney(inputMoney);
    }
}

