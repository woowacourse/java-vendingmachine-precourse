package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

import static vendingmachine.utils.VerificationUtil.validateHoldingAmount;

public class VendingMachineService {

    private Change change;
    private Money money;
    private Product product;
    private VendingMachine vendingMachine;

    public Money createMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

        while (true) {
            try {
                String inputMoney = Console.readLine();

                validateHoldingAmount(inputMoney);

                int moneyPrice = Integer.parseInt(inputMoney);

                Money money = new Money(moneyPrice);

                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
