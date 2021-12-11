package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {

    public static final String WON = "원";
    public static final String COUNT = "개";
    public static final String PRODUCT_INFO_DELIMITER = ";";

    public void start() {
        int holdingAmount = inputHoldingAmount();
        CoinContainer coinContainer = new CoinContainer();
        coinContainer.init(holdingAmount);
        printHoldingCoins(coinContainer);

        List<Product> productList = inputProductInfo();
        ProductContainer productContainer = new ProductContainer(productList);
        int balance = inputBalance();

        VendingMachine vendingMachine = new VendingMachine(balance, productContainer, coinContainer);
        while (true) {
            printBalance(vendingMachine);

            if (vendingMachine.isAllSoldOut() || !vendingMachine.isHavingBalanceToBuy()) {
                break;
            }

            vendingMachine.sellProduct(inputProductToBuy());
            System.out.println();
        }
        printChangeCoins(vendingMachine.returnBalance());

    }

    public int inputHoldingAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String holdingAmount = Console.readLine().trim();
        InputValidator.validateInsertedAmount(holdingAmount);

        return Integer.parseInt(holdingAmount);
    }

    public void printHoldingCoins(CoinContainer coinContainer) {
        String result = "자판기가 보유한 동전\n";
        List<Coin> coinList = Arrays.stream(Coin.values())
                                    .sorted(Comparator.comparing(Coin::getAmount).reversed())
                                    .collect(Collectors.toList());
        for (Coin coin : Coin.values()) {
            result += coin.getAmount() + WON + " - " + coinContainer.getCoinCount(coin) + COUNT + "\n";
        }

        System.out.println(result);
    }

    public List<Product> inputProductInfo() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String productInfoInput = Console.readLine().trim();
        InputValidator.validateProductInfoInput(productInfoInput);

        List<String> productInfoList = convertProductInfoInput2ProductInfoList(productInfoInput);
        List<Product> productList = convertProductInfoList2ProductList(productInfoList);

        return productList;
    }

    private List<String> convertProductInfoInput2ProductInfoList(String productInfoInput) {
        return Arrays.asList(productInfoInput.split(PRODUCT_INFO_DELIMITER));
    }

    private List<Product> convertProductInfoList2ProductList(List<String> productInfoList) {
        List<Product> productList = new ArrayList<>();
        for (String productInfo : productInfoList) {
            String[] productInfos = productInfo.substring(1, productInfo.length()-1).split(",");
            String productName = productInfos[0];
            int productPrice = Integer.parseInt(productInfos[1]);
            int productCount = Integer.parseInt(productInfos[2]);
            InputValidator.validateProductPrice(productPrice);

            productList.add(new Product(productName, productPrice, productCount));
        }

        return productList;
    }

    public int inputBalance() {
        System.out.println("투입 금액을 입력해 주세요.");
        String balance = Console.readLine().trim();
        InputValidator.validateInteger(balance);

        return Integer.parseInt(balance);
    }

    public void printBalance(VendingMachine vendingMachine) {
        System.out.println("투입 금액: " + vendingMachine.getBalance() + WON);
    }

    public String inputProductToBuy() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public void printChangeCoins(Coins coins) {
        String result = "잔돈\n";
        List<Coin> coinList = Arrays.stream(Coin.values())
                                    .sorted(Comparator.comparing(Coin::getAmount).reversed())
                                    .collect(Collectors.toList());
        for (Coin coin : coinList) {
            if (coins.getCoinCount(coin) != 0) {
                result += coin.getAmount() + WON + " - " + coins.getCoinCount(coin) + COUNT + "\n";
            }
        }

        System.out.println(result);
    }
}
