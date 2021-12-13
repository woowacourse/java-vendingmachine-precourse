package vendingmachine.system;

public interface Validation {

    public boolean isValidHoldingMoney(String holdingMoney);

    public boolean isValidProductNameAndPriceAndStock(String productNameAndPriceAndStock);

}
