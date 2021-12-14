package vendingmachine;

import vendingmachine.coin.CoinController;
import vendingmachine.customer.CustomerController;
import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.exception.NotFoundException;
import vendingmachine.item.ItemController;
import vendingmachine.utils.message.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class VendingMachineSystem {

    private final int PURCHASE_UNIT = 1;
    private ItemController itemController;
    private CustomerController customerController;
    private CoinController coinController;

    private VendingMachineSystem() {
        itemController = ItemController.getInstance();
        customerController = CustomerController.getInstance();
        coinController = CoinController.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final VendingMachineSystem instance = new VendingMachineSystem();
    }

    public static VendingMachineSystem getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void operate() {
        initializeVendingMachineCoin();
        printVendingMachineCount();

        initializeItemData();
        initializeCustomerInitialAmount();

        startPurchase();
        printChange();
    }

    private void initializeVendingMachineCoin() {
        while(true) {
            try{
                System.out.println(OutputMessage.VENDING_MACHINE_BALANCE_INPUT);
                String inputBalance = Console.readLine();
                System.out.println();
                coinController.convertToCoin(inputBalance);
                break;
            }catch(IllegalArgumentException e) {
                System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private void printVendingMachineCount() {
        System.out.println(OutputMessage.VENDING_MACHINE_COIN_PRINT_TITLE);
        coinController.printAllCoin();
        System.out.println();
    }

    private void initializeItemData() {
        while(true) {
            try{
                System.out.println(OutputMessage.ITEM_INPUT);
                String itemData = Console.readLine();
                System.out.println();
                itemController.addItem(itemData);
                break;
            }catch(IllegalArgumentException e) {
                System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private void initializeCustomerInitialAmount() {
        while(true) {
            try{
                System.out.println(OutputMessage.CUSTOMER_BALANCE_INPUT);
                String initialAmount = Console.readLine();
                System.out.println();
                customerController.createCustomer(initialAmount);
                break;
            }catch(IllegalArgumentException e) {
                System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    private void startPurchase() {
        while(true) {
            customerController.printBalance();
            if(!isPossiblePurchase(customerController.getBalance())){
                break;
            }
            System.out.println(OutputMessage.PURCHASE_ITEM_NAME);
            String itemName = Console.readLine();
            purchaseItem(itemName);
            System.out.println();
        }
    }

    private void purchaseItem(String itemName) {
        int price = itemController.getPriceByName(itemName);
        try{
            itemController.hasStockQuantity(itemName, PURCHASE_UNIT);
            customerController.hasPurchaseAmount(price);

            itemController.purChaseItem(itemName, PURCHASE_UNIT);
            customerController.purchaseItem(price);
        }catch(NotEnoughStockException e) {
            customerController.cancelPurchase(price);
            System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
        }catch(NotEnoughMoneyException e) {
            itemController.cancelPurchase(itemName, PURCHASE_UNIT);
            System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
        }catch(IllegalArgumentException e) {
            System.out.println(OutputMessage.ERROR_MESSAGE_PREFIX + e.getMessage());
        }
    }

    private boolean isPossiblePurchase(int balance) {
        return !itemController.isNotStockAllItem() && !itemController.isLessThanTheLowestAmount(balance);
    }

    private void printChange() {
        coinController.printChange(customerController.getBalance());
    }
}
