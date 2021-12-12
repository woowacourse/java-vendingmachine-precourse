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
        purchase();
        getChanges();
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

    private void purchase() {
        while (vendingMachineService.isPurchaseAvailable()) {
            try {
                showAvailableMoney();
                purchaseByItemName();
            } catch (IllegalArgumentException error) {
               showErrorMessage(error.getMessage());
            }
        }
    }

    private void getChanges() {
        console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
        console.printChange(vendingMachineService.giveChange());
    }

    private void showAvailableMoney() {
        console.printAvailableMoney(vendingMachineService.checkAvailableMoney());
    }

    private void purchaseByItemName() {
        vendingMachineService.purchaseByItemName(console.inputItemsToPurchase());
    }

    private void showErrorMessage(String errorMessage) {
        console.printErrorMessage(errorMessage);
    }
}
