package vendingmachine;

import java.util.Map;
import java.util.Set;

public class Speaker {

    private static final String VENDING_MACHINE_ASSET = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String VENDING_MACHINE_COIN_STOCK = "자판기가 보유한 동전";
    public static final String PRODUCTS_FORMAT = "상품명과 가격, 수량을 입력해 주세요. [상품명,가격,수량];[,,] 형태";
    public static final String INSERT_MONEY = "투입 금액을 입력해 주세요.";

    public void requestVendingMachineAsset() {
        System.out.println(VENDING_MACHINE_ASSET);
    }

    public void announceCoinStock(Map<Coin, Integer> coinBox) {
        System.out.println(VENDING_MACHINE_COIN_STOCK);
        Set<Coin> coins = coinBox.keySet();
        for (Coin coin : coins) {
            System.out.println(coin.getCoinValue() + "원" + " - " + coinBox.get(coin) + "개");
        }
    }

    public void requestProducts() {
        System.out.println(PRODUCTS_FORMAT);
    }

    public void announceInsertMoney() {
        System.out.println(INSERT_MONEY);
    }

    public void announceBalance(int insertedMoney) {
        System.out.println("투입 금액: " + insertedMoney + "원");
    }

    public void announceChanges() {
        System.out.println("잔돈");
    }

    public void announceCoinAmount(Coin coin, Integer coinCount) {
        System.out.println(coin.getCoinValue() + "원 - " + coinCount + "개");
    }

    public void requestPurchaseProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
    }
}
