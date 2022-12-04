package vendingmachine.controller;

import vendingmachine.vendingmachine.Coin;
import vendingmachine.goods.GoodsManager;
import vendingmachine.vendingmachine.CoinMaker;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CoinMaker coinMaker = new CoinMaker();
    GoodsManager goodsManager;

    public void gameStart() {
        String money = inputView.inputVendingMoney();
        makeVendingMachineCoin(money);
    }

    private void makeVendingMachineCoin(String money) {
        coinMaker.randomCoin(money);
        outputView.vendingMachineCoin(Coin.makeCoinList());
        makeGoodsCataLog();
    }

    private void makeGoodsCataLog() {
        String goodsCataLog = inputView.inputGoodsPriceAmount();
        goodsManager = new GoodsManager(goodsCataLog);
        InputUserMoney();
    }

    private void InputUserMoney() {
        int money = Integer.parseInt(inputView.inputUserMoney());
        outputView.remainMoney(money);
        purchaseGoods(money);
    }


    private void purchaseGoods(int money) {
        while (goodsManager.validMinPurchase(money)) {
            String goods = inputView.inputPurchaseGoods();
            if (!goodsManager.validPurchase(goods, money)) break;

            money = goodsManager.purchaseGoods(goods, money);
            outputView.remainMoney(money);
        }
        returnCoin(money);
    }

    private void returnCoin(int money) {
        if (money == 0) return;
        outputView.returnCoinList(coinMaker.remainCoinList(money));
    }
}
