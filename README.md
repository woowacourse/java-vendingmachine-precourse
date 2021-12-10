# 미션 - 자판기

## 🚀 기능 요구사항

### 자판기 운영

- 사용자가 투입한 금액으로 계속해서 상품 구매를 할 수 있다.
- 여러 상품 구매 후 남은 금액이 ```상품의 최저 가격보다 적거나```, ```모든 상품이 소진된 경우``` 남은 금액을 돌려준다.

### 잔돈 반환

- 지폐로 잔돈을 반환하는 경우는 없다.
- 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
- 남은 금액이 ```상품의 최저 가격보다 적거나```, ```모든 상품이 소진된 경우``` 바로 잔돈을 반환한다.
- 잔돈을 반환한다는 것은 투입한 금액 중 사용하고 남은 금액을 **자판기가 보유한 동전으로 잔돈을 생성**해 돌려주는 것을 의미한다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
  - 반환되지 않은 금액은 자판기에 남는다.
  - 사용자가 투입한 금액으로는 동전을 생성하지 않기 때문에 **반환되지 않은 금액을 잔돈 반환에 사용하지 않는다.**
  
### 상품 입력

- 상품명, 가격, 수량 순으로 입력한다.
- 상품 가격은 100원부터 시작하며, 10원으로 나누어 떨어져야 한다.
- 1개 상품은 ```[콜라,1500,20]``` 같은 형식으로 대괄호와 쉼표(,) 를 사용해 작성한다.
- 개별 상품을 구분하기 위해 ```[콜라,1500,20];[사이다,1000,10]``` 같이 세미콜론(;) 으로 구분한다.

