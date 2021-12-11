package vendingmachine.domain.vendingMachine;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.domain.vendingMachine.InputMoney;
import vendingmachine.domain.vendingMachine.MachineMoney;
import vendingmachine.domain.vendingMachine.MerchandiseList;

import java.util.ArrayList;

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

    public void setInputMoney(String inputMoney) {
        this.inputMoney = new InputMoney(inputMoney);
    }

    public String getInputMoney() {
        return inputMoney.toString();
    }

    public void makeRandomAllCoin() {
        for (Coin c : coin.values()) {
            makeRandomCoin(c);
        }
    }

    private void makeRandomCoin(Coin coin) {
        while (machineMoney.getMoney() != 0) {
            int number = Randoms.pickNumberInList(coin.getAmountList());
            if (number <= machineMoney.getMoney()) {
                machineMoney.minusMoney(number);
                coin.randomCoinCount(number);
            }
        }
    }

    public void addMerchandise(String merchandise) {
        merchandiseList.addAllMerchandise(merchandise);
    }

    public String getAllMerchandiseInfo() {
        return merchandiseList.getAllMerchandiseInfo();
    }

    public void purchase(String merchandiseName) {
        merchandiseList.purchase(merchandiseName, inputMoney.getInputMoney());
        inputMoney.use(merchandiseList.getPrice(merchandiseName));
    }

    public boolean canPurchase() {
        if (merchandiseList.cantBuyAllMerchandise(inputMoney.getInputMoney()) || merchandiseList.AllMerchandiseSoldOut()) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getChange() {
        ArrayList<String> changeList = new ArrayList<String>();
        for (Coin coin : Coin.values()) {
            int moneyToCoin = inputMoney.getInputMoney() / coin.getAmount();

            if (moneyToCoin < coin.getCount()) {
                coin.setCount(moneyToCoin);
                changeList.add(coin.toString());
                return changeList;
            }
            changeList.add(coin.toString());
            inputMoney.subtractMoney(moneyToCoin * coin.getAmount());
        }
        return changeList;
    }
}

