package vendingmachine.controller;

import java.util.List;
import vendingmachine.dto.ChangeDTO;
import vendingmachine.dto.ProductDTO;
import vendingmachine.exception.RetryHandler;
import vendingmachine.service.CoinManager;
import vendingmachine.service.StockManager;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final CoinManager coinManager;
    private final StockManager stockManager;
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryHandler handler;


    public MachineController(CoinManager coinManager, StockManager stockManager, InputView inputView,
                             OutputView outputView,
                             RetryHandler handler) {
        this.coinManager = coinManager;
        this.stockManager = stockManager;
        this.inputView = inputView;
        this.outputView = outputView;
        this.handler = handler;
    }

    public void run() {
        setVendingMachine();
        List<ProductDTO> productDTOS = setInventory();
        int inputAmount = getInputAmount();
        purchaseProduct(inputAmount, productDTOS);
        returnChange(stockManager.getCurrentAmount());
    }

    public void setVendingMachine() {
        //TODO: 보유 금액 입력 메시지 출력
        outputView.printAskMachineMoney();

        //TODO: 사용자로부터 보유 금액 입력
        int machineMoney = handler.execute(inputView::getMachineMoney, IllegalArgumentException.class);

        //TODO: 입력받은 값을 통해 자판기가 보유한 동전 설정
        coinManager.initCoin(machineMoney);

        //TODO: 자판기가 보유하고 있는 동전 출력
        outputView.printCoinStatus(coinManager.getOwnCoinStatus());
    }

    public List<ProductDTO> setInventory() {
        //TODO: 상품명, 가격, 수량 입력 메시지 출력
        outputView.printAskStockInfo();

        //TODO: 사용자로부터 정보 입력
        return handler.execute(inputView::getStockInfo, IllegalArgumentException.class);
    }

    public int getInputAmount() {
        //TODO: 투입 금액 입력 메시지 출력
        outputView.printAskInputAmount();

        //TODO: 투입 금액 입력
        return handler.execute(inputView::getInputAmount, IllegalArgumentException.class);
    }

    public void purchaseProduct(int inputAmount, List<ProductDTO> productDTOS) {
        stockManager.initStock(inputAmount, productDTOS);

        //TODO: StockManager를 통해 상품 구매 조건 충족 여부 확인
        while (stockManager.canPurchase()) {
            //TODO: 구매할 상품명 메시지 출력
            outputView.printCurrentAmount(stockManager.getCurrentAmount());
            outputView.printAskProductName();

            //TODO: 구매할 상품명 입력
            String productName = handler.execute(inputView::getProductName, IllegalArgumentException.class);

            //TODO: StockManager를 통해 제품 구매
            stockManager.buyProduct(productName);
        }
    }

    public void returnChange(int remain) {
        //TODO: 남은 투입 금액 정보 출력
        outputView.printCurrentAmount(remain);

        //TODO: 잔돈 정보 출력
        ChangeDTO changeDTO = coinManager.getChangeInfo(remain);
        outputView.printCoinStatus(changeDTO);
    }
}
