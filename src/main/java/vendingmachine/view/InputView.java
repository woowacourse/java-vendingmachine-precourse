package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Validator;

public class InputView {
    private InputView() {}

    /**
     * 자판기가 초기에 갖고 있는 돈을 입력하는 함수
     * @return
     */

    public static int inputMachineHoldMoney() {
        try {
            OutputView.printMachineInputMoneyMsg();
            String inputMoney = Console.readLine();
            Validator.validateMachineHasMoneyInput(inputMoney);
            Validator.validateMachineHasMoneyInputType(inputMoney);
            return Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
        return -1;
    }

    /**
     * 상품명, 가격, 수량을 입력하는 함수
     * @return
     */
    public static String inputProductDetail() {
        return Console.readLine();
    }

    public static int inputMoney() {
        OutputView.printInputMoneyMsg();
        return Integer.parseInt(Console.readLine());
    }

    public static String inputPurchaseProduct() {
        OutputView.printPurchaseProductInputMsg();
        return Console.readLine();
    }
}
