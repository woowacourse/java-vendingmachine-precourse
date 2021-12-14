package vendingmachine.coin;

import vendingmachine.coin.dto.CoinDto;
import vendingmachine.utils.message.OutputMessage;
import vendingmachine.utils.validator.InputDataValidator;
import vendingmachine.utils.validator.MoneyDataValidator;

import java.util.ArrayList;
import java.util.List;

public class CoinController {

    private CoinService coinService;
    private InputDataValidator inputDataValidator;

    private CoinController() {
        coinService = CoinService.getInstance();
        inputDataValidator = MoneyDataValidator.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CoinController instance = new CoinController();
    }

    public static CoinController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void convertToCoin(String initialAmount) {
        inputDataValidator.validateData(initialAmount);
        coinService.convertToCoin(Integer.parseInt(initialAmount));
    }

    public void printChange(int remainingAmount) {
        List<CoinDto> change = getChange(remainingAmount);
        List<String> changeOutputMessage = convertOutputMessage(change);
        for(String message : changeOutputMessage) {
            System.out.println(message);
        }
    }

    private List<CoinDto> getChange(int remainingAmount) {
        return coinService.createChange(remainingAmount);
    }

    public void printAllCoin() {
        List<CoinDto> coins = getAllCoin();
        List<String> coinOutputMessage = convertOutputMessage(coins);
        for(String message : coinOutputMessage) {
            System.out.println(message);
        }
    }

    private List<CoinDto> getAllCoin() {
        return coinService.getAllCoin();
    }
    private List<String> convertOutputMessage(List<CoinDto> coinDtoList) {
        List<String> outputMessage = new ArrayList<>();

        coinDtoList.sort((a, b) -> b.getCoinAmount() - a.getCoinAmount());
        for(CoinDto coinDto : coinDtoList) {
            outputMessage.add(OutputMessage.COIN_FORMAT
                    .replace("amount", String.valueOf(coinDto.getCoinAmount()))
                    .replace("count", String.valueOf(coinDto.getCount())));
        }
        return outputMessage;
    }
}