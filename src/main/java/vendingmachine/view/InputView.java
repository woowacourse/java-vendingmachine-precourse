package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private InputView() {}

    /**
     * 자판기가 초기에 갖고 있는 돈을 입력하는 함수
     * @return
     */

    public static int inputMachineHoldMoney() {
        OutputView.printMachineInputMoneyMsg();
        return Integer.parseInt(Console.readLine());
    }

    /**
     * 상품명, 가격, 수량을 입력하는 함수
     * @return
     */
    public static String inputProductDetail() {
        return Console.readLine();
    }

    public static int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public static String inputPurchaseProduct() {
        return Console.readLine();
    }
}
