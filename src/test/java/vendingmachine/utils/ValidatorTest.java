package vendingmachine.utils;

import java.util.regex.Pattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Constant;

class ValidatorTest {
	@Test
	void regexTest() {

		String[] trueInfos = {
				"[콜라,1500,20]",
				"[콜1라,1500,20]",
				"[12콜we1라,1500,20]",
				"[콜1라11,1500,20]",
				"[콜1라AS11fk2,1500,20]"
		};

		String[] falseInfos = {
				"[콜1라ASD11fk2,1500,20]",
				"[qwe12콜we1라,1500,20,qwe12콜we1라,1500,20]",
				"[qwe12콜we1라,1500,20],[qwe12콜we1라,1500,20]",
				"[qwe12콜we1라,a1500,20]",
				"[qwe12콜we1라,1a500,20]",
				"[qwe12콜we1라,1500,2r0]",
				"[콜라,1500000000000000,20]",
				"[콜라,1500,200000000000000000]",
				"[콜라라라라라라랄라라라라라라라라라라랄라라라라라라라라라라라랄라라라라라라라라라라라라라라라라ㅏㄹ라라라,1500,200]",
				"[콜라라라라라라랄라라라라라라라라라라랄라라라라라라라라라라라랄라라라라라라라라라라라라라라라라라라라,1500,200]",
				"[,1500,20]",
				"콜라,1500,20]",
				"[콜라,1500,20",
				"[콜라,1500,20,10]",
				"[콜라,,20]",
				"[콜라,1500,]",
				"[콜라,,]",
				"[콜라,]",
				"[,,]",
				"[,,,]",
				"[콜라,1500,20]]",
				"[[콜라,1500,20]",
				"[[[콜라,1500,20]",
				"[[[]]]",
				"[][[]]]",
				"[콜라,1,20]]",
				"[콜라,150020]]",
				"[콜라1500 ,20]]",
				"[]",
				""
		};
		String checker = Constant.VALIDATE_ITEM_INFO_FORMAT;

		for (String trueInfo : trueInfos) {
			boolean checked = Pattern.matches(checker, trueInfo);
			Assertions.assertThat(checked).isTrue();
		}
		
		for (String falseInfo : falseInfos) {
			boolean checked = Pattern.matches(checker, falseInfo);
			Assertions.assertThat(checked).isFalse();
		}
	}
}
