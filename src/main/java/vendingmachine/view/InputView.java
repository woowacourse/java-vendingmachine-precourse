package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.ItemName;
import vendingmachine.domain.Wallet;
import vendingmachine.service.ItemService;
import vendingmachine.service.VendingMachineService;

public class InputView {

    public static Wallet getWallet() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return VendingMachineService.getWallet(Console.readLine());
    }

    public static Items getItems() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return ItemService.getItems(Console.readLine());
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
