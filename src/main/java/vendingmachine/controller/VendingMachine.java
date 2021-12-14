package vendingmachine.controller;

import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.domain.vendingMachine.VendingMachineAmount;
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
    private VendingMachineAmount vendingMachineAmount;

    private Products products = new Products();
    private UserMoney userMoney;
    public VendingMachine() {
    }

    public void run() {
        setVendingMachineAmount();
        OutputView.printCoinCount(vendingMachineAmount.getVendingMachineCoinCombination());
        setProduct();

        setUserMoney();
        OutputView.printUserMoney(userMoney);

        inputProductByUser();
    }

    private void setVendingMachineAmount() {
        try {
            vendingMachineAmount = new VendingMachineAmount(InputView.getVendingMachineAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setVendingMachineAmount();
        }
    }

    private void setProduct() {
        try {
            products = ProductService.makeProducts(InputView.getProducts());
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
            CoinCombination changeCoinCombination = CoinGenerator.calculatePossibleCoinCombination(totalChange);
            changeCoinCombination.print();
        }
    }

    private boolean isReturnChange() {
        return userMoney.canNotBuyCheapestProduct(products) || products.isSoldOut();
    }
}