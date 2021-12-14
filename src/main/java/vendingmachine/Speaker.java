package vendingmachine;

import java.util.Map;
import java.util.Set;

public class Speaker {

    private static final String VENDING_MACHINE_ASSET = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String VENDING_MACHINE_COIN_STOCK = "자판기가 보유한 동전";
    private static final String PRODUCTS_FORMAT = "상품명과 가격, 수량을 입력해 주세요. [상품명,가격,수량];[,,] 형태";
    private static final String INSERT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String ERROR = "[ERROR] ";
    private static final String WON = "원";
    private static final String DASH = " - ";
    private static final String COUNT = "개";
    private static final String NOT_FOUND_COIN = "코인을 찾을 수 없습니다.";
    private static final String CHANGES = "잔돈";
    private static final String WANTED_PRODUCT = "구매할 상품명을 입력해 주세요.";
    private static final String INSERTED_MONEY = "투입 금액: ";

    public void requestVendingMachineAsset() {
        System.out.println(VENDING_MACHINE_ASSET);
    }

    public void announceCoinStock(Map<Coin, Integer> coinBox) {
        System.out.println(VENDING_MACHINE_COIN_STOCK);
        Set<Coin> coins = coinBox.keySet();
        for (Coin coin : coins) {
            System.out.println(coin.getAmount() + WON + DASH + coinBox.get(coin) + COUNT);
        }
    }

    public void requestProducts() {
        System.out.println(PRODUCTS_FORMAT);
    }

    public void announceInsertMoney() {
        System.out.println(INSERT_MONEY);
    }

    public void announceBalance(int insertedMoney) {
        System.out.println(INSERTED_MONEY + insertedMoney + WON);
    }

    public void announceChanges() {
        System.out.println(CHANGES);
    }

    public void announceCoinAmount(Coin coin, Integer coinCount) {
        System.out.println(coin.getAmount() + WON + DASH + coinCount + COUNT);
    }

    public void requestPurchaseProduct() {
        System.out.println(WANTED_PRODUCT);
    }

    public void announceError(String message) {
        System.out.println(ERROR + message);
    }
}
