package vendingmachine.domain;

public class VendingMachine {
    private final PossessionCoins possessionCoins;
    private final Products products;

    public VendingMachine(PossessionCoins possessionCoins, Products products) {
        this.possessionCoins = possessionCoins;
        this.products = products;
    }

    public boolean isOperate(InvestmentMoney investmentMoney) {
        if (products.isPossiblePurchase(investmentMoney)) {
            return true;
        }
        return false;
    }

    public void buy(InvestmentMoney investmentMoney, ProductPurchase productPurchase) {
        String productPurchaseName = productPurchase.getName();
        Product product = products.findByName(productPurchaseName).orElseThrow(IllegalArgumentException::new);

        investmentMoney.calculate(product);
    }

    public Changes getChanges(InvestmentMoney investmentMoney) {
        return new Changes(possessionCoins.takeChange(investmentMoney));
    }
}