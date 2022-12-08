package vendingmachine.domain.coins;

import java.util.List;

public interface NumberGenerator {

    int generate(List<Integer> numbers);
}
