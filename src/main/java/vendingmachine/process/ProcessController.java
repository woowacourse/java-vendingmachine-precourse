package vendingmachine.process;

import vendingmachine.goods.GoodsController;
import vendingmachine.machine.Coin;
import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;
import vendingmachine.machine.MachineReturnChange;

public class ProcessController {
    public static Coin[] coins = Coin.values();
    Machine machine;
    static GoodsController goodsController;

    private static int holdingAmount;
    private static int userMoney;

    public static void makeHoldingAmount(MachineHoldingAmount machineHoldingAmount) {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_HOLDING_AMOUNT);
                holdingAmount = ProcessPrepareHoldingAmount.makeHoldingAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        machineHoldingAmount.makeCoins();
    }

    public static void printMachineCoins() {
        System.out.println(ProcessConstant.PRINT_HOLDING_AMOUNT);
        for (int i = 0; i<coins.length; i++) {
            System.out.println(ProcessConstant.COINS[i] + coins[i].getNumber() + ProcessConstant.UNIT);
        }
    }

    public static void inputGoods() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_GOODS);
                goodsController = new GoodsController(ProcessPrepareGoods.makeGoods());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void inputUserMoney() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_USER_MONEY);
                userMoney = ProcessPrepareUserMoney.makeUserMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void buyGoods() {
        while (true) {
            try {
                System.out.println(ProcessConstant.USER_MONEY + userMoney);
                if (!ProcessUserBuyGoods.checkCanBuy(goodsController, userMoney)) {
                    break;
                }
                System.out.println(ProcessConstant.ASK_BUY_GOODS_NAME);
                ProcessUserBuyGoods.inputGoodsName();
                ProcessUserBuyGoods.existsGoodsName(goodsController);
                userMoney = ProcessUserBuyGoods.sellGoods(goodsController, userMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void makeChanges() {
        MachineReturnChange.makeChanges(userMoney);

        System.out.println(ProcessConstant.EXCHANGE);

        for (int i=0; i<coins.length; i++) {
            if (MachineReturnChange.isThisCoinZero(coins[i])) {
                continue;
            }
            System.out.println(ProcessConstant.COINS[i] + MachineReturnChange.getCoinNumber(i)+ProcessConstant.UNIT);
        }
    }
}
