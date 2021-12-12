package vendingmachine;

import java.util.ArrayList;

public class Machine {
    private static int money;
    private ArrayList<Product> products;
    private boolean purchasable = true;
    //private Coin coins;

    Machine() {
        Coin.makeRandom(InputView.inputMachineMoney());
        OutputView.printMachineCoin();
        this.products = InputView.inputProductList();
        this.money = InputView.inputMoney();
        while (purchasable) {
            OutputView.printMoney(money);
            //남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다
            this.purchasable = isPurchasable(InputView.inputProduct());
        }
        OutputView.printChanges();
    }

    public boolean isPurchasable(String productName) {
        //System.out.println("isPurchasable 들어왔습니다."+productName);
        for (Product product : this.products) {
            if (product.getName().equals(productName) && product.getPrice() <= money && product.getCount() > 0) {
                reduceMoney(product.getPrice());
                product.reduceCount();
                return true;
            }
        }
        return false;
    }

    public void reduceMoney(int reduceMoney) {
        this.money -= reduceMoney;
    }

    public static int makeChanges(Coin coin) {
        int changes = money/coin.getAmount();
        if (changes != 0) {
            if (coin.getCount() - changes >= 0) {
                return changes;
            }
            if (coin.getCount() -changes < 0) {
                return coin.getCount();
            }
        }
        return 0;
    }
}
