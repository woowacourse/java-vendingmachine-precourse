package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.util.ErrorMessage;

import java.util.*;

import static vendingmachine.Coin.*;
import static vendingmachine.util.Message.*;

public class Change {
    private final List<Integer> coins = getCoins();
    private final Map<Coin, Integer> haveCoin;
    Map<Coin, Integer> leftCoins;
    private final int startChange;

    public Change(int change) {
        // change 에 따라 랜덤 동전 뽑아서 갯수 저장하기
        haveCoin = initCoin();
        changeValidation(change);
        startChange = change;
        coinMaker(change);
    }

    private void changeValidation(int change) {
        if (change % coins.stream()
                .mapToInt(o -> o).min()
                .orElseThrow(IllegalArgumentException::new) != 0)
            throw new IllegalArgumentException(ErrorMessage.CHANGE_INPUT_EXCEPTION.getMessage());
    }

    private Map<Coin, Integer> initCoin() {
        Map<Coin, Integer> initCoin = new LinkedHashMap<>();
        for (Coin tempCoin : Coin.values()) {
            initCoin.put(tempCoin, 0);
        }
        return initCoin;
    }

    private void coinMaker(int change) {
        while (change != 0) {
            int randomCoin = Randoms.pickNumberInList(coins);
            if (randomCoin <= change) {
                haveCoin.put(of(randomCoin), haveCoin.get(of(randomCoin)) + 1);
                change -= randomCoin;
            }
        }
    }


    public String startChangePrint() {
        StringBuilder print = new StringBuilder();
        print.append(MACHINE_HAS_CHANGE.getMessage());
        for (Coin tempCoin : haveCoin.keySet()) {
            print.append(tempCoin.getAmount());
            print.append(CHANGE_AMOUNT_PREFIX.getMessage());
            print.append(haveCoin.get(tempCoin));
            print.append(CHANGE_AMOUNT_SUFFIX.getMessage());
        }
        return print.toString();
    }

    public void saveLeftCoin(int amount){
        if(amount >= startChange){
            leftCoins = haveCoin;
            return;
        }
        leftCoins = new LinkedHashMap<>();
        int changeAmount = 0;
        for(Coin tempCoin : haveCoin.keySet()){
            if(amount < tempCoin.getAmount()){
                continue;
            }
            while(haveCoin.get(tempCoin) > 0 && changeAmount < amount){
                leftCoins.put(tempCoin, leftCoins.getOrDefault(tempCoin, 0)+1);
                haveCoin.put(tempCoin, haveCoin.get(tempCoin)-1);
                changeAmount += tempCoin.getAmount();
            }
        }
        return;
    }

    public String leftChangePrint(){
        StringBuilder print = new StringBuilder();
        print.append(CHANGE_MESSAGE.getMessage());
        for (Coin tempCoin : leftCoins.keySet()) {
            if(leftCoins.get(tempCoin) >0){
                print.append(tempCoin.getAmount());
                print.append(CHANGE_AMOUNT_PREFIX.getMessage());
                print.append(leftCoins.get(tempCoin));
                print.append(CHANGE_AMOUNT_SUFFIX.getMessage());
            }
        }
        return print.toString();
    }
    // 남은 금액보다 같거나 작게 가장 큰 동전부터 거슬러줌
    // 500원 잔돈, 750원 거슬러줘야함 모두
    // 500원 잔돈 300원 거슬러줘야함
}
