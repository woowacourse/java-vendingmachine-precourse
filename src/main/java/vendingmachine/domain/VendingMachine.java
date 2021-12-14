package vendingmachine.domain;

import vendingmachine.domain.change.Changes;
import vendingmachine.domain.investmentmoney.InvestmentMoney;
import vendingmachine.domain.possessioncoin.PossessionCoins;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.productpurchase.ProductPurchase;

public class VendingMachine {
    private static final String VALID_POSSIBLE_PURCHASE = "[ERROR] 구매할 수 있는 상품이 없습니다.";
    private static final String VALID_PRODUCT_NAME = "[ERROR] 일치하는 상품명이 없습니다.";

    private final PossessionCoins possessionCoins;
    private final Products products;

    public VendingMachine(PossessionCoins possessionCoins, Products products) {
        this.possessionCoins = possessionCoins;
        this.products = products;
    }

    public void checkPossiblePurchase(InvestmentMoney investmentMoney) {
        if (!isOperate(investmentMoney)) {
            throw new IllegalArgumentException(VALID_POSSIBLE_PURCHASE);
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
        Product product = products.findByName(productPurchaseName)
            .orElseThrow(() -> new IllegalArgumentException(VALID_PRODUCT_NAME));

        product.receive();
        investmentMoney.calculate(product.getPrice());
    }

    public Changes getChanges(InvestmentMoney investmentMoney) {
        return new Changes(possessionCoins.takeChange(investmentMoney));
    }
}