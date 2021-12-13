package vendingmachine.view;

import vendingmachine.util.Constant;

public class Output {

    private Output() {
    }

    public static void printGuideMessage(String guideContent) {
        System.out.println(guideContent);
    }

    public static void printErrorMessage(String content) {
        System.out.println(String.format("%s %s", Constant.ERROR, content));
    }
}
