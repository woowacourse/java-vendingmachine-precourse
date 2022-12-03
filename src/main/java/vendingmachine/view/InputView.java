package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.VendingMachineException;

public class InputView {
    VendingMachineException vendingMachineException = new VendingMachineException();

    public String inputVendingMoney(){
        System.out.println(GameMessage.INPUT_VENDINGMACHINE_MONEY);
        String vendingMoney = Console.readLine();
        vendingMachineException.validMoneyInputForm(vendingMoney);
        vendingMachineException.validMoneyRange(vendingMoney);
        return vendingMoney;
    }

    public String inputGoodsPriceAmount(){
        System.out.println(GameMessage.INPUT_GOODS_PRICE_AMOUNT);
        String goods = Console.readLine();
        vendingMachineException.validGoodsInputForm(goods);
        return goods;
    }

    public String inputUserMoney(){
        System.out.println(GameMessage.INPUT_USER_MONEY);
        String userMoney = Console.readLine();
        vendingMachineException.validMoneyInputForm(userMoney);
        vendingMachineException.validMoneyRange(userMoney);
        return userMoney;
    }

    public String inputPurchaseGoods(){
        System.out.println(GameMessage.INPUT_PURCHASE_GOODS);
        String goods = Console.readLine();
        return goods;
    }

}
