package vendingmachine.domain;

import vendingmachine.domain.change.Changes;
import vendingmachine.domain.investmentmoney.InvestmentMoney;
import vendingmachine.domain.possessioncoin.PossessionCoins;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.productpurchase.ProductPurchase;

public class VendingMachine {
    private final PossessionCoins possessionCoins;
    private final Products products;

    public VendingMachine(PossessionCoins possessionCoins, Products products) {
        this.possessionCoins = possessionCoins;
        this.products = products;
    }

    public void checkPossiblePurchase(InvestmentMoney investmentMoney) {
        if (!isOperate(investmentMoney)) {
            throw new IllegalArgumentException();
        }
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