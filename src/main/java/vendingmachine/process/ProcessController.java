package vendingmachine.process;

import vendingmachine.goods.Goods;
import vendingmachine.goods.GoodsController;
import vendingmachine.machine.Coin;
import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;
import vendingmachine.machine.MachineReturnChange;

import java.util.List;

public class ProcessController {
    public static Coin[] coins = Coin.values();
    static Machine machine;
    static MachineHoldingAmount machineHoldingAmount;
    static GoodsController goodsController;

    private static int holdingAmount;
    private static int userMoney;

    public static void makeHoldingAmount() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_HOLDING_AMOUNT);
                holdingAmount = ProcessPrepareHoldingAmount.makeHoldingAmount();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void makeCoins() {
        machine = new Machine(holdingAmount);
        machineHoldingAmount = new MachineHoldingAmount(machine);
        machineHoldingAmount.makeCoins();
    }

    public static void printMachineCoins() {
        System.out.println(ProcessConstant.PRINT_HOLDING_AMOUNT);
        for (int i = 0; i<coins.length; i++) {
            System.out.println(ProcessConstant.COINS[i] + coins[i].getNumber() + ProcessConstant.UNIT);
        }
        System.out.println();
    }

    public static void inputGoods() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_GOODS);
                ProcessPrepareGoods.makeGoods();
                break;
            } catch (IllegalArgumentException e) {
                ProcessPrepareGoods.clearList();
                System.out.println(e.getMessage());
            }
        }
        goodsController = new GoodsController(ProcessPrepareGoods.produceGoods());
        System.out.println();
    }

    public static void inputUserMoney() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_USER_MONEY);
                userMoney = ProcessPrepareUserMoney.makeUserMoney();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void buyGoods() {
        while (true) {
            try {
                System.out.println(ProcessConstant.USER_MONEY + userMoney + ProcessConstant.MONEY_UNIT);
                if (!ProcessUserBuyGoods.checkCanBuy(goodsController, userMoney)) {
                    return;
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
            if (MachineReturnChange.isThisCoinZero(i)) {
                continue;
            }
            System.out.println(ProcessConstant.COINS[i] + MachineReturnChange.getCoinNumber(i)+ProcessConstant.UNIT);
        }
    }
}
