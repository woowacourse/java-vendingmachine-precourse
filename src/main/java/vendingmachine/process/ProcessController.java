package vendingmachine.process;

public class ProcessController {
    private static int holdingAmount;

    public static void makeHoldingAmount() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_HOLDING_AMOUNT);
                holdingAmount = ProcessPrepareHoldingAmount.makeHoldingAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
