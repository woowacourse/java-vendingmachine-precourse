package vendingmachine.controller;

import vendingmachine.vendingmachine.Coin;
import vendingmachine.goods.GoodsManager;
import vendingmachine.vendingmachine.VendingMachineManager;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GoodsManager goodsManager = new GoodsManager();

    int count = 0;

    public void gameStart() {
        String money = inputView.inputVendingMoney();
        makeVendingMachineCoin(money);
    }

    public void makeVendingMachineCoin(String money) {
        VendingMachineManager vendingMachineManager = new VendingMachineManager();
        vendingMachineManager.makeRandomCoin(money);
        outputView.vendingMachineCoin(Coin.makeCoinList());
        makeGoodsList();
    }

    public void makeGoodsList() {
        String goodsList = inputView.inputGoodsPriceAmount();
        goodsManager.makeGoodsList(goodsList);
        InputUserMoney();
    }

    public void InputUserMoney() {
        int money = Integer.parseInt(inputView.inputUserMoney());
        outputView.remainMoney(money);
        purchaseGoods(money);
    }


    public void purchaseGoods(int money) {
        while(true){
            if(!goodsManager.validMinPurchase(money))break;
            String goods = inputView.inputPurchaseGoods();
            if(!goodsManager.validPurchase(goods,money))break;
            money = goodsManager.purchaseGoods(goods, money);
            outputView.remainMoney(money);
        }
        returnCoin(money);
    }

    public void returnCoin(int money) {
        VendingMachineManager vendingMachineManager = new VendingMachineManager();
        outputView.returnCoinList(vendingMachineManager.makeRemainCoinList(money));
    }
}
