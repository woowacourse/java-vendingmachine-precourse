package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Stock;
import vendingmachine.dto.ProductInfo;

public class StockManager {
    private InputAmount inputAmount;
    private Stock stock; // 상품 정보 저장

    public void initStock(int inputAmount, List<ProductInfo> productInfos) {
        this.inputAmount = InputAmount.create(inputAmount);
        this.stock = Stock.create(productInfos);
    }

    public boolean canPurchase() {
        int minGoodsPrice = stock.getMinGoodsPrice();
        if ((minGoodsPrice > inputAmount.getCurrentMoney()) || (stock.isRunOutOfStock())) {
            return false;
        }
        return true;
    }

    public void buyProduct(String productName) {
        int productPrice = stock.decreaseStock(productName);
        inputAmount.pay(productPrice);
    }

    public int getCurrentAmount() {
        return inputAmount.getCurrentMoney();
    }
}
