package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.*;
import java.util.stream.Stream;

import static vendingmachine.Constant.*;

public class Application {
    public static void main(String[] args) throws Throwable {
        Machine machine = new Machine();
        LinkedHashMap<Coin, Integer> coinMap = machine.getCoins();
        int machineInputMoney = InputView.inputMachineHoldMoney();
        machine.generateCoin(machineInputMoney);
        OutputView.printMachineHasCoins(coinMap);
//

        List<Product> products = new ArrayList<>();
        String[] productsInput = InputView.inputProductDetail().split(";"); // 입력받아서 ;로 분리함
        for (int i = 0; i < productsInput.length; i++) {
            String productDetail = productsInput[i].replaceAll(Constant.REX, "");
            String[] productInfo = productDetail.split(",");
            Product freshProduct = new Product(productInfo[0],Integer.parseInt(productInfo[1]),Integer.parseInt(productInfo[2]));
            products.add(freshProduct);
        }
        int minProductPrice = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            if (minProductPrice > products.get(i).getPrice()) {
                minProductPrice = products.get(i).getPrice();
            }
        }
        int userMoneyInput = InputView.inputMoney();
        while (userMoneyInput > minProductPrice) {
            OutputView.printCurrentInputMoney(userMoneyInput);
            String purchasingProduct = InputView.inputPurchaseProduct();
            Product inputProduct = products.stream()
                    .filter(x -> x.getName().equals(purchasingProduct))
                    .findFirst().orElse(null);
            if(inputProduct == null) {
                throw new IllegalArgumentException("[ERROR]");
            }
            userMoneyInput -= inputProduct.getPrice();
        }

        OutputView.printCurrentInputMoney(userMoneyInput);
        OutputView.printChange(coinMap);


        // [콜라,1200,20];[사이다,2000,20]

    }
}
