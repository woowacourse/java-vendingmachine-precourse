package vendingmachine;

import static Constants.CommonValues.FALSE;

import Constants.Coin;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private int vendingMachineMoney;
    private Map<Coin, Integer> coinBox;
    private List<Product> productShelf;

    public VendingMachine(int vendingMachineMoney, Map<Coin, Integer> coinBox, List<Product> productShelf) {
        this.vendingMachineMoney = vendingMachineMoney;
        this.coinBox = coinBox;
        this.productShelf = productShelf;
    }

    public int hasSuchProduct(String wishList) {
        for (Product product : productShelf) {
            if (product.askItsName().equals(wishList)) {
                return productShelf.indexOf(product);
            }
        }
        return FALSE;
    }

    public List<Product> getShelf() {
        return productShelf;
    }

    public int getPrice(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        return product.askItsPrice();
    }

    public void decreaseStock(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        product.sellProduct();
    }

    public Map<Coin, Integer> returnChanges(Customer customer) {
        ChangeCalculator changeCalculator = new ChangeCalculator(vendingMachineMoney, coinBox, customer);
        return changeCalculator.calculateResult();
    }

    public Map<Coin, Integer> askItsCoinBox() {
        return coinBox;
    }
}
