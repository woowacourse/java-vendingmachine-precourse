package vendingmachine.process;

import vendingmachine.goods.GoodsController;
import vendingmachine.machine.Coin;
import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;

public class ProcessController {
    public static Coin[] coins = Coin.values();
    Machine machine;
    static GoodsController goodsController;

    private static int holdingAmount;

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
}
