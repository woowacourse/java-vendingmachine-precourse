package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

public class WalletPrinter {
    private final WalletSystem wallet;
    private final String PRINT_TITLE_MESSAGE = "\n자판기가 보유한 동전";
    private final String PRINT_INSERTED_BALANCE_MESSAGE = "투입 금액: ";
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

    void printRemainInsertedBalance(){
        System.out.println(PRINT_INSERTED_BALANCE_MESSAGE + wallet.getInsertedBalance() + StringConstants.CURRENCY_UNIT);
    }
}
