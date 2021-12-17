package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.ChangeController;
import vendingmachine.controller.CustomerController;
import vendingmachine.controller.ProductController;
import vendingmachine.domain.Change;
import vendingmachine.domain.Customer;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private Change change;
    private Customer customer;

    public void run() {
        inputChange();
        inputProduct();
        inputMoney();
        buyProduct();
        returnChange();
    }

    // 1. 보유 잔돈  입력
    public void inputChange() {
        inputView.printInputChange();
        String inputChange = Console.readLine();
        int intChange = Integer.parseInt(inputChange);
        change = new Change(intChange);
        outputView.printCoinList(change);
    }

    // 2. 보유 상품 입력
    public void inputProduct() {
        inputView.printInputProducts();
        String products = Console.readLine();
        // 상품 분류 및 상품 추가 기능  수행
    }

    // 3. 투입 금액  입력
    public void inputMoney() {
        inputView.printInputMoney();
        String inputMoney = Console.readLine();
        int intMoney = Integer.parseInt(inputMoney);
        outputView.printMoney(intMoney);
    }

    // 4. 상품 구매
    public void buyProduct() {
        inputView.printInputBuyProduct();
        String product = Console.readLine();
        int money=0;
        // 상품 구매 로직 구현
        outputView.printMoney(money);
    }

    // 5. 잔돈 반환
    public void returnChange() {
        outputView.printChange(customer);
    }
}
