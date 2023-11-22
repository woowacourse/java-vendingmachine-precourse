package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.domain.Product;
import vendingmachine.domain.Stock;
import vendingmachine.service.StockManager;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final StockManager stockManager;
    private final InputView inputView;
    private final OutputView outputView;


    public MachineController(StockManager stockManager, InputView inputView, OutputView outputView) {
        this.stockManager = stockManager;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        //TODO: temp code
        Map<String, Product> stockInfo = new HashMap<>();
        stockInfo.put("콜라", Product.create("콜라", 1000, 5));
        stockInfo.put("펩시", Product.create("펩시", 900, 5));
        stockInfo.put("탐스제로", Product.create("탐스제로", 1200, 5));
        stockManager.initInventory(10000, Stock.create(stockInfo));

        setVendingMachine();
        setInventory();
        int inputAmount = getInputAmount();
        purchaseProduct(inputAmount);
        returnChange();
    }

    public void setVendingMachine() {
        //TODO: 보유 금액 입력 메시지 출력

        //TODO: 사용자로부터 보유 금액 입력

        //TODO: 입력받은 값을 통해 자판기가 보유한 동전 설정

    }

    public void setInventory() {
        //TODO: 상품명, 가격, 수량 입력 메시지 출력
        outputView.printAskStockInfo();

        //TODO: 사용자로부터 정보 입력
        inputView.getStockName();

        //TODO: 입력한 값을 통해 재고를 관리하는 객체 생성

    }

    public int getInputAmount() {
        //TODO: 투입 금액 입력 메시지 출력
        outputView.printAskInputAmount();

        //TODO: 투입 금액 입력
        return inputView.getInputAmount();
    }

    public void purchaseProduct(int inputAmount) {
//        stockManager.initInventory(inputAmount, );

        //TODO: StockManager를 통해 상품 구매 조건 충족 여부 확인
        while (stockManager.canPurchase()) {
            //TODO: 구매할 상품명 메시지 출력
            outputView.printCurrentAmount(stockManager.getCurrentAmount());
            outputView.printAskProductName();

            //TODO: 구매할 상품명 입력
            String productName = inputView.getProductName();

            //TODO: StockManager를 통해 제품 구매
            stockManager.buyProduct(productName);
        }
    }

    public void returnChange() {
        //TODO: 남은 투입 금액 정보 출력

        //TODO: 잔돈 정보 출력

    }
}
