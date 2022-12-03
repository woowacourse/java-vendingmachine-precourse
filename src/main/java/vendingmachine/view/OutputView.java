package vendingmachine.view;

public class OutputView {
    public void askPricePrint(){
       printMessage("자판기가 보유하고 있는 금액을 입력해주세요.");
    }
    public void printMessage(String input){
        System.out.println(input);
    }
}
