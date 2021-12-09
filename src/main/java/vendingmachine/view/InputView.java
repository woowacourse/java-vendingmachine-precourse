package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Asset;

public class InputView {

    public static final String INPUT_REQUEST_INITIAL_ASSET = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public Asset getInitialAsset() {
        try {
            return new Asset(Integer.parseInt(Console.readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInitialAsset();
        }
    }
}
