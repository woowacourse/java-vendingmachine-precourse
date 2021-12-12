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
        boolean completed = false;
        String products = VendingMachineInput.insertProducts();

        do{
            try {
                vendingMachine.insertProducts(products);
                completed = true;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!completed);

        // 투입 금액 입력 받기
        int inputMoney = -1;
        do {
            try {
                inputMoney = VendingMachineInput.insertInputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (inputMoney == -1);

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
