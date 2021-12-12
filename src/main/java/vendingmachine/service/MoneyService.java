package vendingmachine.service;

import vendingmachine.domain.Money;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.utils.VerificationUtil.validateHoldingAmount;

public class MoneyService {

    public Money createMoney() {
        while (true) {
            try {
                String inputMoney = readLine();

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
