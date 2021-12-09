package vendingmachine.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinConstants {

    public static List<Integer> getCoinValues() {
        return Stream.of(10, 50, 100, 500).collect(Collectors.toList());
    }
}
