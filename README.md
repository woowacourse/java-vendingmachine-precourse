# 미션 - 자판기

## 구현 기능
### 0. Util
1. 입력받기
- 일련의 동작을 수행한다.
  1. arg : Validator 함수
  2. 동작1 : try { raedLine -> Validator -> return String }
  3. 동작2: catch (Exception error) { println(error.getMessage())}
  4. try 가 성공할 때까지 반복

### 1. Entity
1. 가격
- 생성 : 입력(int) + 동작(에러체크) [x]
- 반환 : 출력(int) [x]
- 에러체크 : 단위체크(10 이하단위 사용 불가, 음수 사용 불가) [x]

2. 잔여 (Remaining)<T>
- 필드 : 해시맵(T, INTEGER) // T = 물건
- 생성 : 입력(T, int) [x]
- 잔여 개수 반환 : 입력(T), 출력(int) [x]
- 잔여량 차감 : 입력(T), 동작(에러체크,int-1), 출력(boolean) [x]
- 에러체크 : 남은 개수가 0개 (혹은 이하)인데 차감하려고 하는가? [x]
- 상품별 잔여량 :  입력(상품), 동작(에러체크), 출력(int) [x]
- 에러체크 : 상품이 없는 경우 [x]

3. 동전 (enum)
- 필드 : 이름, 가격 [x]

4. 상품
- 필드 : 이름, 가격 (private final)
- 이름 : 출력(이름) [x]
- 가격 : 출력(가격) [x]

5. 동전 리스트
- 필드 : 잔여량 <동전>
- 동전 종류 리스트 : [x]
- 동전별 잔여량 : 입력(동전(종류)), 출력(int) [x] (2. Remaining 에 작성)

6. 상품 리스트
- 필드 : 잔여량 <상품>
- 상품 리스트 : 출력(List<String>) [x]
- 최저가 반환 : 출력(int) [x]

7. 잔고
- 필드 : 생성 (금액)
- 차감 :
- 잔고 반환 :
-

### 2. 자판기
1. 동전 재고 생성 : 입력(금액), 동작(동전 재고생성)
2. 동전 재고 출력 : 출력(동전 종류별 개수)
3. 상품 생성 : 입력(상품 리스트) -> 동작(상품 리스트 생성)
4. 투입 금액 입력 : 입력(금액)

--반복--
5. 남은금액 계산 : 동작(투입금액 / 상품 최저가 비교)
6. 주문 받기 : 입력(상품명), 동작(투입금액 차감)
7. 잔고 출력 : 출력(금액)
   --
8. 잔돈 반한 : 출력(반환 동전 개수)

### 3. user interface
1. 동전 재고 생성 : 입력 (금액)
  1. 금액을 입력하라는 안내문구 출력 [x]
  2. 금액 입력 받음 [x]
  3. 문자열 -> 숫자로 변환 [x]
  4. 숫자를 500, 100, 50, 10의 합계로 변환 [x]
  5. 코인 리스트 생성 [ ]

2. 상품 생성 : 입력 (상품 리스트)
  1. 상품 입력 받기 [x]
  2. ";" 를 기준으로 split (상품) [x]
  3. "," 를 기준으로 split (상품명,가격,개수) (String,int,int) [x]
     -> 상품명에 대한 검증, 가격에 대한 검증, 개수에 대한 검증
     -> 상품명 : isBlank(x), 1 <= 길이
     -> 가격 : isDigit(x)
     -> 개수 : isDigit(x)
  4. 상품 리스트 생성 [x]
  5. 입력 예시 : [콜라,1500,20];[사이다,1000,10]

3. 투입 금액 : 입력 (금액)
  1. 금액 입력 받기
     -> 검증 : isDigit(), isAmount() [x]
  2. 입력받음 금액 저장하기 [x]
  3. 차감하기 [x]

4. 주문하기
  1.
  2.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

반환되는 동전이 최소한이 되는 자판기를 구현한다.

- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
   - 투입 금액으로는 동전을 생성하지 않는다.
- 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
- 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
- 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
   - 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.
- 사용자가 투입한 금액으로 상품을 구매할 수 있다.
- 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
   - 반환되지 않은 금액은 자판기에 남는다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.