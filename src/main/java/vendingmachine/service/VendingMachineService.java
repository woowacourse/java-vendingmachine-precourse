package vendingmachine.service;

import vendingmachine.domain.*;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class VendingMachineService {

    public VendingMachine createVendingMachine(Change change, List<Product> productList, Money money) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.createChange(change);
        vendingMachine.inputProducts(productList);
        vendingMachine.inputMoney(money);

        return vendingMachine;
    }

    public void progressVendingMachine(VendingMachine vendingMachine) {
        while (vendingMachine.checkProgress()) {
            System.out.println("\n투입 금액: " + vendingMachine.getRestMoney());

            System.out.println("구매할 상품명을 입력해 주세요.");

            String productName = readLine();

            vendingMachine.extractProduct(productName);
        }
    }
}
