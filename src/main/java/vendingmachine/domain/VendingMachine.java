package vendingmachine.domain;

public class VendingMachine {
    private final PossessionCoins possessionCoins;
    private final Products products;

    public VendingMachine(PossessionCoins possessionCoins, Products products) {
        this.possessionCoins = possessionCoins;
        this.products = products;
    }

    public void buy(InvestmentMoney investmentMoney, ProductPurchase productPurchase) {
        String productPurchaseName = productPurchase.getName();
        Product product = products.findByName(productPurchaseName).orElseThrow(IllegalArgumentException::new);

        investmentMoney.calculate(product);
    }
}