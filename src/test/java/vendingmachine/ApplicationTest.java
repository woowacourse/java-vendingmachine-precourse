package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
//import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomNumberInListTest(
            () -> {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다");
                assertThat(output()).contains(
                    "자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
                    "투입 금액: 3000원", "투입 금액: 1500원"
                );
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
            () -> {
                runException("-1");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }



    @Test
    void readproductTest(){
        InputView inputview=new InputView();

        List<String> exactFormat= Arrays.asList("[콜라,1500,20]", "[사이다,1000,10]");

        assertThat(exactFormat.toString()).isEqualTo(inputview.readproduct_list("[콜라,1500,20];[사이다,1000,10]").toString());
    }

    @Test
    void set_vending_products테스트(){

        Vendingmachine vendingmachine=new Vendingmachine();
        List<String> testFormat=Arrays.asList("[콜라,1500,20]", "[사이다,1000,10]");
        List<Product> resultFormat=Arrays.asList(new Product("콜라","1500","20"));

       // System.out.print(vendingmachine.set_vending_products(testFormat).get(0).getprice());
        assertThat(vendingmachine.set_vending_products(testFormat).get(0).getprice()).isEqualTo(resultFormat.get(0).getprice());
    }
    @Test
    void set_coins테스트(){

        Vendingmachine vendingmachine=new Vendingmachine();


        List<Integer> testFormat=Arrays.asList(0,4,1,0);

        assertThat(vendingmachine.set_coins(450).toString()).isEqualTo(testFormat.toString());
    }
}
