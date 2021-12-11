package vendingmachine.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
public class CoinController {

    private final CoinService coinService = new CoinService();

    public Coin pickPossibleRandomCoin(int money){
        return coinService.findCoinByPrice(money);
    }
}
