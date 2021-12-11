package vendingmachine.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
public class CoinController {

    public CoinController(){
    }


    private List<Integer> getPossibleAmountList(int money){
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .filter(amount -> amount<= money)
                .collect(Collectors.toList());
    }
    private Coin findCoinByPrice(int price){
        return Arrays.stream(Coin.values())
                .filter(coin ->price==coin.getAmount())
                .collect(Collectors.toList())
                .get(0);
    }

    public Coin pickPossibleRandomCoin(int money){
        return findCoinByPrice(pickNumberInList(getPossibleAmountList(money)));
    }
}
