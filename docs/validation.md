
# 검증 로직

검증 로직은 특정 객체가 갖는 속성이 올바른지 아닌지 확인하는 용도로 사용하는데요. [이동욱님의 일급컬렉션](https://jojoldu.tistory.com/412)에서 나와있다시피, 검증 로직과 객체가 따로 분리되어 있다면 __"모든 코드와 도메인을 알고있지 않는 한"__, 문제가 발생할 여지가 있습니다.

따라서 객체와 로직이 함께 존재해야 하는데, 하나 둘 씩 중복되는 검증 로직이 보이기 시작했습니다. 가령, "금액"과 "수량"은 __둘 다__ 0 이상의 양수를 가져야한다는 조건을 주고 싶었습니다. 그런데 각각의 클래스에 같은 코드를 반복하는 것은 그다지 좋은 선택이 아니라고 생각했습니다.

![](DRY.png)

또 불만이었던 점은,"검증 로직이 너무 많아질 경우, 클래스가 커진다"는 것입니다. 에러 메시지가 해당 클래스에 같이 존재하는 것도 껄끄러웠구요. 

```java
public class Name {
	private static final String ERROR_EMPTY = "이름은 빈 문자열일 수 없습니다.";
	private static final String ERROR_TOO_LONG = String.format("이름은 %d자를 초과할 수 없습니다.", Name.MAX_SIZE);

	public static final int MAX_SIZE = 5;

	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		validateBlank(name);
		validateLength(name);
	}

	private void validateBlank(String name) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException(ERROR_EMPTY);
		}
	}

	private void validateLength(String name) {
		if (name.length() > MAX_SIZE) {
			throw new IllegalArgumentException(ERROR_TOO_LONG);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
```
(지난 2주차 과제에서 위와 같이 구현하였습니다. 검증로직이 제일 기네요.)

따라서 이를 별도의 클래스로 구분하고, 필요할때마다 호출할 수 있도록 하고자 하였습니다. 그와 더불어, 검증로직의 추가/삭제 등이 용이하도록 만들고자 하였습니다.

```java
public class PositiveIntegerValidation implements Validation<Integer> {

	private static final String FORMAT = "%s 는(은) 0 미만이 될 수 없습니다.";

	@Override
	public void validate(Integer target, String name) throws IllegalArgumentException {
		if (target < 0) {
			throw new IllegalArgumentException(String.format(FORMAT, name));
		}
	}
}
```

그리고 `Validation`을 대신 수행해주는 `Validator` 클래스를 만들고, 주어진 Validation을 수행하도록 만들었습니다.

```java
public class Validator {

	public static <T> T validate(String name, T target, Validation<T> ... validations) {
		for (Validation<T> validation : validations) {
			validation.validate(target, name);
		}
		return target;
	}
}
```

마지막으로 사용하는 측에서는, 아래와 같이 사용하기만 하면 됩니다.

```java
public class Money {
	
	...

	public Money(int amount) {
		this.amount = Validator.validate(NAME, amount, new PositiveIntegerValidation());
	}

	...
}
```

이렇게 검증로직을 따로 분리해내니, 다음과 같은 장점을 얻을 수 있었습니다.

1. 검증 코드가 너무 길어지지 않는다.
2. 검증 로직의 중복을 제거할 수 있다.
3. 도메인 객체는 도메인에만 집중할 수 있다.(당장 필요없는 static 에러 메시지가 별도로 분리되는 등..)
