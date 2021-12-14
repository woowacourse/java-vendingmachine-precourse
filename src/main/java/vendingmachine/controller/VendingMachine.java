package vendingmachine.controller;

import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.domain.vendingMachine.Amount;
import vendingmachine.validator.AmountValidator;
import vendingmachine.validator.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private Amount amount;
    private CoinCombination vendingMachinCoinCombination;
    private CoinCombination changeCoinCombination;

    private Products products = new Products();
    private UserMoney userMoney;
    public VendingMachine() {
    }

    private void setAmount() {
        try {
            String vendingmachineAmount = InputView.getVendingmachineAmount();
            AmountValidator.checkVendingMachineAmount(vendingmachineAmount);
            amount = new Amount(Integer.parseInt(vendingmachineAmount));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setAmount();
        }
    }

    private void setProduct() {
        try {
            String productForm = InputView.getProducts();
            String[] productInformations = productForm.split(";");
            for (String productInformation : productInformations) {
                ProductValidator.checkProduct(productInformation);
                String[] product = productInformation.replaceAll("[\\[\\]]", "").split(",");
                AmountValidator.checkProductPrice(product[1]);
                products.add(new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setProduct();
        }
    }

    private void setUserMoney() {
        try {
            String userMoney = InputView.getUserMoney();
            AmountValidator.checkVendingMachineAmount(userMoney);
            this.userMoney = new UserMoney(Integer.parseInt(userMoney));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setUserMoney();
        }
    }

    public void inputUserMoney() {
        setUserMoney();
        OutputView.printUserMoney(userMoney);
    }

    public void inputProducts() {
        setProduct();
        OutputView.printProducts(products);
    }

    public void inputAmount() {
        setAmount();
        vendingMachinCoinCombination = new CoinCombination();
        CoinGenerator.calculatePossibleCoinCombination(vendingMachinCoinCombination, amount.getAmount());
        OutputView.printCoinCount(vendingMachinCoinCombination);
    }

    public void inputProductByUser() {
        while (!isReturnChange()) {
            String productByUser = InputView.getProductByUser();
            Product pro = products.reduce(productByUser);
            userMoney.reduce(pro.getPrice());
            OutputView.printUserMoney(userMoney);
        }
    }

    public void returnChange() {
        if (!userMoney.canBuyCheapestProduct(products) || products.isSoldOut()) {
            int totalChange = userMoney.reduceMoney();
            changeCoinCombination = new CoinCombination();
            CoinGenerator.calculatePossibleCoinCombination(changeCoinCombination, totalChange);
            changeCoinCombination.print();
        }
    }

    private boolean isReturnChange() {
        if (!userMoney.canBuyCheapestProduct(products) || products.isSoldOut()) {
            return true;
        }
        return false;
    }
}