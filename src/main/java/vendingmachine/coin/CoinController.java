package vendingmachine.coin;

import vendingmachine.coin.dto.CoinDto;
import vendingmachine.utils.message.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public class CoinController {

    private CoinService coinService;

    private CoinController() {
        coinService = CoinService.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CoinController instance = new CoinController();
    }

    public static CoinController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void convertToCoin(int initialAmount) {
        coinService.convertToCoin(initialAmount);
    }

    public List<String> getChange(int remainingAmount) {
        List<String> changeResult = new ArrayList<>();

        List<CoinDto> change = coinService.createChange(remainingAmount);
        change.sort((a, b) -> b.getCoinAmount() - a.getCoinAmount());

        for(CoinDto coinDto : change) {
            changeResult.add(OutputMessage.CHANGE_FORMAT
                    .replace("amount", String.valueOf(coinDto.getCoinAmount()))
                    .replace("count", String.valueOf(coinDto.getCount())));
        }
        return changeResult;
    }
}