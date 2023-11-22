package vendingmachine.service;

import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Stock;

public class StockManager {
    private InputAmount inputAmount;
    private Stock stock; // 상품 정보 저장

    public void initInventory(int inputAmount, Stock stock) {
        this.inputAmount = InputAmount.create(inputAmount);
        this.stock = stock;
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
