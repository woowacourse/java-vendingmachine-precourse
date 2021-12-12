package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.VendingMachineInput;
import vendingmachine.view.VendingMachineOutput;


public class VendingMachineController {

    public void run() {
        // 자판기가 보유할 금액 입력 받기
        int amount = -1;
        do {
            try {
                amount = VendingMachineInput.insertAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (amount == -1);

        VendingMachine vendingMachine = new VendingMachine(amount);

        // 자판기가 보유한 동전 출력
        vendingMachine.printCoins();

        // 자판기가 보유할 상품 입력 받기
        String products = VendingMachineInput.insertProducts();
        vendingMachine.insertProducts(products);

        // 투입 금액 입력 받기
        int inputMoney = VendingMachineInput.insertInputMoney();
        vendingMachine.setInputMoney(inputMoney);

        while(vendingMachine.checkPurchasePossible()) {
            vendingMachine.printRestMoney();
            String productName = VendingMachineInput.insertProductNameToBuy();
            vendingMachine.reduceInputMoneyAndProductQuantityByName(productName);
        }

        vendingMachine.printRestMoney();
        vendingMachine.printChanges();

    }
}
