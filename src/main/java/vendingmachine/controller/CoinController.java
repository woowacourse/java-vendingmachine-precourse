package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineMoney;

public class CoinController {
    public static void makeCoin(VendingMachineMoney vendingMachineMoney){
        int remainChange = vendingMachineMoney.getTotalMoney();

        remainChange = remainChange - makeCoin500(vendingMachineMoney, remainChange);
        remainChange = remainChange - makeCoin100(vendingMachineMoney, remainChange);
        remainChange = remainChange - makeCoin50(vendingMachineMoney, remainChange);
        makeCoin10(vendingMachineMoney, remainChange);
    }

    private static int makeCoin500(VendingMachineMoney vendingMachineMoney, int remainChange) {
        if (remainChange < Coin.COIN_500.getAmount()){
            return 0;
        }
        int maxRandomSize = remainChange/Coin.COIN_500.getAmount();
        int randomCount = Randoms.pickNumberInRange(0, maxRandomSize);
        vendingMachineMoney.setMoneyCount500(randomCount);

        return Coin.COIN_500.getAmount()*randomCount;
    }

    private static int makeCoin100(VendingMachineMoney vendingMachineMoney, int remainChange) {
        if (remainChange < Coin.COIN_100.getAmount()){
            return 0;
        }
        int maxRandomSize = remainChange/Coin.COIN_100.getAmount();
        int randomCount = Randoms.pickNumberInRange(0, maxRandomSize);
        vendingMachineMoney.setMoneyCount100(randomCount);

        return Coin.COIN_100.getAmount()*randomCount;
    }

    private static int makeCoin50(VendingMachineMoney vendingMachineMoney, int remainChange) {
        if (remainChange < Coin.COIN_50.getAmount()){
            return 0;
        }
        int maxRandomSize = remainChange/Coin.COIN_50.getAmount();
        int randomCount = Randoms.pickNumberInRange(0, maxRandomSize);
        vendingMachineMoney.setMoneyCount50(randomCount);

        return Coin.COIN_50.getAmount()*randomCount;
    }

    private static void makeCoin10(VendingMachineMoney vendingMachineMoney, int remainChange) {
        int count = remainChange/Coin.COIN_10.getAmount();
        vendingMachineMoney.setMoneyCount10(count);
    }
}
