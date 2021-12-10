package vendingmachine;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void on() {
        console.printCurrentBalance(vendingMachineService.createCoinBalance(console.inputCoinBalance()));
        vendingMachineService.createItems(console.inputItemInventoryInfo());
        vendingMachineService.insertMoney(console.inputMoneyToInsert());
        console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
        purchaseItem();
    }

    private void purchaseItem() {
        boolean isItemAvailable = false;
        while (!isItemAvailable) {
            try {
                vendingMachineService.purchaseByItemName(console.inputItemsToPurchase());
                isItemAvailable = true;
            } catch (IllegalArgumentException error) {
                console.printErrorMessage(error.getMessage());
            }
        }
    }
}
