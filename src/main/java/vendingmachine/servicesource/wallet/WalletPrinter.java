package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

import java.util.HashMap;

public class WalletPrinter {
    private final WalletSystem wallet;
    private final String PRINT_TITLE_MESSAGE = "\n자판기가 보유한 동전";
    private final String PRINT_NOT_ENOUGH_BALANCE_MESSAGE = "잔액으로 살 수 있는 상품이 더 이상 없어, 잔돈을 반환합니다.";
    private final String RETURN_CHANGE_MESSAGE = "잔돈";
    private final String PRINT_INSERTED_BALANCE_MESSAGE = "\n투입 금액: ";
    private final String PRINT_DELIMITER = " - ";

    WalletPrinter(WalletSystem wallet){
        this.wallet = wallet;
    }

    void printAllCoins(){
        Coin[] coinTypes =  Coin.values();
        System.out.println(PRINT_TITLE_MESSAGE);

        for(Coin currentCoin : coinTypes){
            int remainCoinsInWallet = wallet.getRemainCoinsByCoinType(currentCoin);
            System.out.println(currentCoin + PRINT_DELIMITER + remainCoinsInWallet + StringConstants.PRODUCT_UNIT);
        }

        System.out.print('\n');
    }

    void printReturnedCoins(HashMap<Coin, Integer> returnCoinsMap){
        System.out.println(RETURN_CHANGE_MESSAGE);

        for(Coin currentCoin: Coin.getSortedCoinTypes()){

            if(returnCoinsMap.get(currentCoin) != 0){
                System.out.println(currentCoin + PRINT_DELIMITER + returnCoinsMap.get(currentCoin) + StringConstants.PRODUCT_UNIT);
            }

        }

    }

    void printRemainInsertedBalance(){
        System.out.println(PRINT_INSERTED_BALANCE_MESSAGE + wallet.getInsertedBalance() + StringConstants.CURRENCY_UNIT);
    }

    void printNotEnoughBalance(){
        System.out.println(PRINT_NOT_ENOUGH_BALANCE_MESSAGE);
    }
}
