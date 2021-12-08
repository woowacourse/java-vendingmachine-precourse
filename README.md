# 자판기

반환되는 동전이 최소한이 되는 자판기

## 👀 기능 목록

- `상품명`, `가격`, `수량` 순서로 입력을 받고, 쉼표를 기준으로 구분짓는다.
    - `상품명`은 한글만 허용한다.
    - `가격`은 숫자만 허용하고, 100원 부터 시작하고 10원으로 나누어 떨어지는지 검증한다.
    - `수량`은 0을 제외한 자연수인지 검증한다.
- 각각의 상품은 `대괄호`로 묶여야 한다.
- 상품이 2개 이상일 때, 각 상품은 `세미콜론`으로 구분 짓는다.

- 자판기가 보유하고 있는 금액은 10원으로 나누어 떨어져야 한다.
- 동전은 500원, 100원, 50원, 10원 단위로 구성된다.
- 투입 금액으로 새로운 동전을 생성하지 않는다.
- `남은 금액 < 상품의 최저가격`일 때 잔돈을 반환한다.
- 모든 상품이 소진된 경우 잔돈을 반환한다.
- `잔돈 > 자판기가 보유하고 있는 금액`일 때 반환 할 수 있는 금액만 반환한다.
    - 그렇지 않으면 동전의 개수가 최소가 되도록 잔돈을 반환한다.
