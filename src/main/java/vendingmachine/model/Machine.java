package vendingmachine.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static vendingmachine.util.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Machine {
    int machineMoney;
    int userMoney;
    Map<Coin, Integer> coins;
    Map<String, Menu> menus;

    public Machine() {
        userMoney = 0;
        coins = new HashMap<>();
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
        menus = new HashMap<>();
    }

    public void setMachineMoney(int money) {
        this.machineMoney = money;
    }

    public void generateRandomCoins() {
        while (machineMoney != 0) {
            int randomAmount = Randoms.pickNumberInList(Coin.getAmountsList());
            if (randomAmount <= machineMoney) {
                Coin pickedCoin = Coin.pick(randomAmount);
                int count = coins.getOrDefault(pickedCoin, 0);
                coins.put(pickedCoin, count+1);
                machineMoney -= randomAmount;
            }
        }
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int money) {
        userMoney = money;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public int getLowestPrice() {
        int lowestPrice = Integer.MAX_VALUE;
        for (Menu menu : menus.values()) {
            if (lowestPrice > menu.getPrice()) {
                lowestPrice = menu.getPrice();
            }
        }
        return lowestPrice;
    }

    public boolean allZeroStocks() {
        boolean allZeroStocks = true;
        for (Menu menu : menus.values()) {
            if (menu.getStock() != 0) {
                allZeroStocks = false;
                break;
            }
        }
        return allZeroStocks;
    }

    public void setMenus(String userInput) {
        for (String userStr : userInput.split(SPLIT_MENUS_DELIMETER)) {
            Pattern pattern = Pattern.compile(MACHINE_MENUS_PATTERN);
            Matcher matcher = pattern.matcher(userStr);
            if (matcher.find()) {
                Menu menu = new Menu(matcher.group(1), matcher.group(2), matcher.group(3));
                menus.put(matcher.group(1), menu);
            }
        }
    }

    public void purchaseMenu(String menuName) throws IllegalArgumentException, NullPointerException {
        try {
            Menu targetMenu = menus.get(menuName);
            if (targetMenu.getStock() == 0) {
                throw new IllegalArgumentException(WRONG_MENU_STOCK);
            }
            userMoney -= targetMenu.getPrice();
            targetMenu.setStock(targetMenu.getStock() - 1);
        } catch (NullPointerException e) {
            throw new NullPointerException(WRONG_MENU_NAME);
        }
    }

    public Map<Integer, Integer> changeCoins() {
        Map<Integer, Integer> changeCoins = new HashMap<>();
        for (Coin coin : Coin.values()) {
            int count = userMoney / coin.getAmount();
            changeCoins.put(coin.getAmount(), count);
            userMoney -= coin.getAmount() * count;
        }
        return changeCoins;
    }
}
