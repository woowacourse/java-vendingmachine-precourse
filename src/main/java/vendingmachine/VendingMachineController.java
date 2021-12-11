package vendingmachine;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;
    private final VendingMachineConsole console = new VendingMachineConsole();

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void on() {
        createCoinBalance();
        createItems();
        createAvailableMoney();
        purchaseItem();
        console.printChange(vendingMachineService.giveChange());
    }
    
    private void createCoinBalance() {
        console.printCoinBalance(vendingMachineService.createCoinBalance(console.inputCoinBalance()));
    }
    
    private void createItems() {
        vendingMachineService.createItems(console.inputItemInventoryInfo());
    }

    private void createAvailableMoney() {
        vendingMachineService.insertMoney(console.inputAvailableMoney());
    }

    private void purchaseItem() {
        while (vendingMachineService.isPurchaseAvailable()) {
            try {
                console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
                vendingMachineService.purchaseByItemName(console.inputItemsToPurchase());
            } catch (IllegalArgumentException error) {
                console.printErrorMessage(error.getMessage());
            }
        }
    }
}
