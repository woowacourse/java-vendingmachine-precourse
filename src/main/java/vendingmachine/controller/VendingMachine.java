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

import static vendingmachine.constant.SystemMessage.*;

// 사용자와 상호작용하면서 소통하는 역할
// 자판기 보유 금액 입력받기
// 상품명 가격 수량 입력받기
// 투입 금액 입력받기
// 구매할 상품명 입력받기
// 잔돈 반환하기

public class VendingMachine {
    private Amount amount;
    private CoinCombination vendingMachinCoinCombination;
    private CoinCombination changeCoinCombination;

    private Products products = new Products();
    private UserMoney userMoney;
    public VendingMachine() {
        vendingMachinCoinCombination = new CoinCombination();
        changeCoinCombination = new CoinCombination();
    }

    public void run() {
        setVendingMachineAmount();
        setVendingMachinCoinCombination();
        OutputView.printCoinCount(vendingMachinCoinCombination);

        setProduct();

        setUserMoney();
        OutputView.printUserMoney(userMoney);

        inputProductByUser();
    }

    private void setVendingMachineAmount() {
        try {
            String vendingmachineAmount = InputView.getVendingMachineAmount();
            AmountValidator.checkVendingMachineAmount(vendingmachineAmount);
            amount = new Amount(Integer.parseInt(vendingmachineAmount));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setVendingMachineAmount();
        }
    }

    private void setVendingMachinCoinCombination() {
        CoinGenerator.calculatePossibleCoinCombination(vendingMachinCoinCombination, amount.getAmount());
    }

    private void setProduct() {
        try {
            String productForm = InputView.getProducts();
            String[] productInformations = productForm.split(PRODUCT_DELIMITER);
            for (String productInformation : productInformations) {
                ProductValidator.checkProduct(productInformation);
                String[] product = productInformation.replaceAll(UNNECESSARY_SPECIAL_CHARACTER_REGEX, BLANK).split(NAME_PRICE_COUNT_DELIMITER);
                AmountValidator.checkProductPrice(product[PRICE]);
                products.add(new Product(product[NAME], Integer.parseInt(product[PRICE]), Integer.parseInt(product[COUNT])));
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

    private void inputProductByUser() {
        while (!isReturnChange()) {
            String productByUser = InputView.getProductByUser();
            Product pro = products.reduce(productByUser);
            userMoney.reduce(pro.getPrice());
            OutputView.printUserMoney(userMoney);
        }
        returnChange();
    }

    private void returnChange() {
        if (isReturnChange()) {
            int totalChange = userMoney.reduceMoney();
            changeCoinCombination = new CoinCombination();
            CoinGenerator.calculatePossibleCoinCombination(changeCoinCombination, totalChange);
            changeCoinCombination.print();
        }
    }

    private boolean isReturnChange() {
        return userMoney.canNotBuyCheapestProduct(products) || products.isSoldOut();
    }
}