package vendingmachine.service;

import vendingmachine.domain.Inventory;

public class StockManager {
    private int inputAmount; //TODO: Wrapper로 한 번 싸기
    private Inventory inventory; // 상품 정보 저장

    public void initInventory(int inputAmount, Inventory inventory) {
        this.inputAmount = inputAmount;
        this.inventory = inventory;
    }

    public boolean canPurchase() {
        int minGoodsPrice = inventory.getMinGoodsPrice();
        if ((minGoodsPrice > inputAmount) || (inventory.isRunOutOfStock())) {
            return false;
        }
        return true;
    }

    public void buyProduct(String productName) {
        int productPrice = inventory.decreaseStock(productName);
        inputAmount -= productPrice;
    }

    public int getCurrentAmount() {
        return inputAmount;
    }
}
