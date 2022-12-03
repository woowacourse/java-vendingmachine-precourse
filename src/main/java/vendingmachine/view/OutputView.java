package vendingmachine.view;

import vendingmachine.domain.Change;
import vendingmachine.enums.Coin;

import java.util.List;

public class OutputView {
    public void askPricePrint(){
       printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }
    public void askProductPrint(){
        printMessage("상품가격과 가격, 수량을 입력해 주세요.");
    }
    public void askInputPricePrint(){
        printMessage("투입 금액을 입력해 주세요.");

    }
    public void printFirstChange(Change change){
        printMessage("자판기가 보유한 동전");
        printMessage(change.toString());
    }
    public void askBuyProductPrint(String hasPrice){
        StringBuilder print = new StringBuilder("투입 금액: "+hasPrice+"원\n");
        print.append("구매할 상품명을 입력해 주세요.\n");
        printMessage(print.toString());
    }
    public void printLastChange(int hasPrice, List<Coin> hasChange){


    }
    public void printMessage(String input){
        System.out.println(input);
    }
}
