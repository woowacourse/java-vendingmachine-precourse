package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void getChange() {
        int money = inputMoney.getInputMoney();
        ArrayList<String> changeList = new ArrayList<String>();

        for (Coin coin : Coin.values()) {
            if (money / coin.getAmount() < coin.getCount()) {
                coin.setCount(money / coin.getAmount());
                changeList.add(coin.toString());
                System.out.println("잔돈");
                changeList.stream().forEach(System.out::println);
                return;
            }
            changeList.add(coin.toString());
            money = money - coin.getCount() * coin.getAmount();
        }
    }
}

