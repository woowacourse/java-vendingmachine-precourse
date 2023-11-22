package vendingmachine.service;

import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Inventory;

public class StockManager {
    private InputAmount inputAmount;
    private Inventory inventory; // 상품 정보 저장

    public void initInventory(int inputAmount, Inventory inventory) {
        this.inputAmount = InputAmount.create(inputAmount);
        this.inventory = inventory;
    }

    public boolean canPurchase() {
        int minGoodsPrice = inventory.getMinGoodsPrice();
        if ((minGoodsPrice > inputAmount.getCurrentMoney()) || (inventory.isRunOutOfStock())) {
            return false;
        }
        return true;
    }

    public void buyProduct(String productName) {
        int productPrice = inventory.decreaseStock(productName);
        inputAmount.pay(productPrice);
    }

    public int getCurrentAmount() {
        return inputAmount.getCurrentMoney();
    }
}
