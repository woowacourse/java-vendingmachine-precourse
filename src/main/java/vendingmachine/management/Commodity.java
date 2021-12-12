package vendingmachine.management;

import vendingmachine.management.validation.CheckCommodityName;
import vendingmachine.management.validation.CheckCommodityPrice;
import vendingmachine.management.validation.CheckCommodityQuantity;

public class Commodity {
    private String name;
    private int price;
    private int quantity;
    
    public Commodity(String name, int price, int quantity) {
        validCommodityName(name);
        validCommodityPrice(price);
        validCommodityQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void subtractQuantity() {
        quantity--;
    }
    
    private void validCommodityName(String name) {
        CheckCommodityName.validation(CommodityRepository.getList(), name);
    }

    private void validCommodityPrice(int price) {
        CheckCommodityPrice.validationRange(price);
        CheckCommodityPrice.validationUnit(price);
    }

    private void validCommodityQuantity(int quantity) {
        CheckCommodityQuantity.validationRange(quantity);
    }

}
