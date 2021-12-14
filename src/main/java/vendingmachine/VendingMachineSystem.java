package vendingmachine;

import vendingmachine.coin.CoinController;
import vendingmachine.customer.CustomerController;
import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.exception.NotEnoughStockException;
import vendingmachine.item.ItemController;
import vendingmachine.utils.message.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

    public void operate() {
        initializeVendingMachineCount();
        printVendingMachineCount();

        initializeItem();
        initializeCustomerInitialAmount();

        startPurchase();
        printChange();
    }

    private void initializeVendingMachineCount() {
        Integer vendingMachineInitialAmount = getVendingMachineInitialAmount();
        coinController.convertToCoin(vendingMachineInitialAmount);
        System.out.println();
    }

    private Integer getVendingMachineInitialAmount() {
        System.out.println(OutputMessage.VENDING_MACHINE_BALANCE_INPUT);
        String inputBalance = Console.readLine();
        return Integer.parseInt(inputBalance);
    }

    private void printVendingMachineCount() {
        coinController.printAllCoin();
        System.out.println();
    }

    private void initializeItem() {
        System.out.println(OutputMessage.ITEM_INPUT);
        String inputItems = Console.readLine();
        itemController.addItem(inputItems);
        //TODO: 예외 처리
        System.out.println();
    }

    private void initializeCustomerInitialAmount() {
        System.out.println(OutputMessage.CUSTOMER_BALANCE_INPUT);
        String initialAmount = Console.readLine();
        customerController.createCustomer(initialAmount);
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
            throw new IllegalArgumentException(e.getMessage());
        }catch(NotEnoughMoneyException e) {
            itemController.cancelPurchase(itemName, PURCHASE_UNIT);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean isPossiblePurchase(int balance) {
        return !itemController.isNotStockAllItem() && !itemController.isLessThanTheLowestAmount(balance);
    }

    private void printChange() {
        coinController.printChange(customerController.getBalance());
    }
}
