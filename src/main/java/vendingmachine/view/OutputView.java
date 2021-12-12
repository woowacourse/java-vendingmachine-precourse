package vendingmachine.view;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
