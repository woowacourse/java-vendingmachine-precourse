package vendingmachine.system.validation;

public interface Validation {

    public boolean isValidHoldingMoney(String holdingMoney);

    public boolean isValidProductNameAndPriceAndStock(String productNameAndPriceAndStock);

    public boolean isValidUserInsertMoney(String userInsertMoney);

    public boolean isValidProductNameToBuy(String productName);
}
