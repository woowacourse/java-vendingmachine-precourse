package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import vendingmachine.dto.ProductInfo;
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
        List<ProductInfo> infos = Arrays.asList(
                new ProductInfo("콜라", 1000, 5),
                new ProductInfo("펩시", 900, 5),
                new ProductInfo("탐스제로", 1200, 5)
        );
        stockManager.initStock(10000, infos);

        setVendingMachine();
        List<ProductInfo> productInfos = setInventory();
        int inputAmount = getInputAmount();
        purchaseProduct(inputAmount, productInfos);
        returnChange();
    }

    public void setVendingMachine() {
        //TODO: 보유 금액 입력 메시지 출력

        //TODO: 사용자로부터 보유 금액 입력

        //TODO: 입력받은 값을 통해 자판기가 보유한 동전 설정

    }

    public List<ProductInfo> setInventory() {
        //TODO: 상품명, 가격, 수량 입력 메시지 출력
        outputView.printAskStockInfo();

        //TODO: 사용자로부터 정보 입력
        return inputView.getStockInfo();
    }

    public int getInputAmount() {
        //TODO: 투입 금액 입력 메시지 출력
        outputView.printAskInputAmount();

        //TODO: 투입 금액 입력
        return inputView.getInputAmount();
    }

    public void purchaseProduct(int inputAmount, List<ProductInfo> productInfos) {
        stockManager.initStock(inputAmount, productInfos);

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
