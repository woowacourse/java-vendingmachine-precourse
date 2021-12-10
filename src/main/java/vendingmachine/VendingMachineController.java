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
        purchaseItem();
        vendingMachineService.giveChange();
    }

    private void purchaseItem() {
        boolean isPurchaseAvailable = true;
        while (isPurchaseAvailable) {
            try {
                console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
                vendingMachineService.purchaseByItemName(console.inputItemsToPurchase());
                isPurchaseAvailable = vendingMachineService.isPurchaseAvailable();
            } catch (IllegalArgumentException error) {
                console.printErrorMessage(error.getMessage());
            }
        }
    }
}
