package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.VendingMachineValidator;

public class InputView {
    VendingMachineValidator vendingMachineValidator = new VendingMachineValidator();

    public String inputVendingMoney(){
        System.out.println(GameMessage.INPUT_VENDINGMACHINE_MONEY);
        String vendingMoney = Console.readLine();
        vendingMachineValidator.allOfValidInput(vendingMoney);
        return vendingMoney;
    }

    public String inputGoodsPriceAmount(){
        System.out.println(GameMessage.INPUT_GOODS_PRICE_AMOUNT);
        String goods = Console.readLine();
        vendingMachineValidator.validGoodsInputForm(goods);
        return goods;
    }

    public String inputUserMoney(){
        System.out.println(GameMessage.INPUT_USER_MONEY);
        String userMoney = Console.readLine();
        vendingMachineValidator.allOfValidInput(userMoney);
        return userMoney;
    }

    public String inputPurchaseGoods(){
        System.out.println(GameMessage.INPUT_PURCHASE_GOODS);
        String goods = Console.readLine();
        return goods;
    }

}
