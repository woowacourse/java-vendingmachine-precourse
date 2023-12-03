package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine.Item;
import vendingmachine.domain.VendingMachine.ItemName;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.service.VendingMachine.VendingMachineService;
import vendingmachine.util.Validator;

public class InputView {
    public static VendingMachine getVendingMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String walletString = Console.readLine();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String itemsString = Console.readLine();
        return VendingMachineService.getVendingMachine(walletString, itemsString);
    }

    public static Money getMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        return Money.of(Console.readLine());
    }

    public static ItemName getItemToBuy() {
        System.out.println("구매할 상품을 입력해 주세요.");
        return new ItemName(Console.readLine());
    }
}
