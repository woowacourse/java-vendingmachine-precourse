package vendingmachine.view;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
