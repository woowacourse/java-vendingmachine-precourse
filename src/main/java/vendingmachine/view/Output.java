package vendingmachine.view;

import java.util.List;

import vendingmachine.model.coin.CoinType;
import vendingmachine.util.Constant;

public class Output {

    private Output() {
    }

    public static void joinMessage(String join, String message) {
        System.out.println(String.format(Constant.STRING_FORMAT, join, message));
    }

    public static void guideMessage(String guideContent) {
        System.out.println(guideContent);
    }

    public static void errorMessage(String content) {
        System.out.println(String.format(Constant.STRING_FORMAT, Constant.ERROR, content));
    }

    public static void changeStatus(List<CoinType> change) {
        StringBuilder status = new StringBuilder();
        for (CoinType coinType : change) {
            status.append(coinType.toString()).append(Constant.NEXT_LINE);
        }
        System.out.println(status);
    }
}
