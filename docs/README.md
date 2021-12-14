# 미션 - 🥤 자판기 🥤

---

## 💁‍♀ 게임 설명

```
안녕하세요. 이 프로젝트는 우아한테크코스 4기 3주차 미션을 진행합니다. 😛

자판기 보유 금액을 입력받고, 해당 금액 만큼 랜덤으로 동전 생성 한 뒤,

자판기에서 판매할 음료의 정보(상품명, 가격, 갯수)를 입력 받고

사용자로부터 투입 금액을 받아 추가 구매가 가능할 때까지 원하는 음료를 뽑고, 

더이상 음료를 뽑을 수 없으면, 최소 갯수의 동전을 반환하고 종료됩니다. 

```

---


## 구현하며 했던 고민들 🤕
- [일급 객체와 일급 컬렉션이 뭘까?](https://github.com/her0807/java-vendingmachine-precourse/wiki/%EC%9D%BC%EA%B8%89-%EA%B0%9D%EC%B2%B4%EC%99%80-%EC%9D%BC%EA%B8%89-%EC%BB%AC%EB%A0%89%EC%85%98)
- [프로젝트 패키지 구조 어떻게 설계 해야 할까?](https://github.com/her0807/java-vendingmachine-precourse/wiki/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%8C%A8%ED%82%A4%EC%A7%80-%EA%B5%AC%EC%A1%B0-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%84%A4%EA%B3%84-%ED%95%B4%EC%95%BC-%ED%95%A0%EA%B9%8C%3F)
- [PR 충돌 이유와 해결 방법](https://github.com/her0807/java-vendingmachine-precourse/wiki/Can%E2%80%99t-automatically-merge)
- [Coin 을 Enum 으로 구현한 이유가 뭘까?](https://github.com/her0807/java-vendingmachine-precourse/wiki/Coin-%EC%9D%84-Enum-%EC%9C%BC%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%9C-%EC%9D%B4%EC%9C%A0%EA%B0%80-%EB%AD%98%EA%B9%8C%3F)

## 🔍 구현할 기능 목록

---

### 입력

- `자판기 보유 금액`을 입력받는다.
    - **[예외]** : 자판기 보유 금액은 10원 이상이어야한다.
    - **[예외]** : 자판기 보유 금액은 10원 단위로 나누어떨어져야 한다.
    - **[예외]** : 보유 금액은 숫자여야 한다.


- `상품명과 가격, 수량` 을 입력 받는다.
    - **[예외]** : 문자열이 `[열린 중괄호` 로 시작하고,  `닫힌 중괄호 ]` 로 끝나야한다.

      <br>

    - **[예외]** : 상품명은 공백이 아니어야 한다.
    - **[예외]** : 상품명은 문자로 시작해야한다. (ex 비타500)
    - **[예외]** : 상풍명은 중복이 될 수 없다.

      <br>

    - **[예외]** : 가격은 공백이 아니어야 한다.
    - **[예외]** : 가격은 숫자여야 한다.
    - **[예외]** : 가격은 100원 이상이어야 한다.
    - **[예외]** : 가격은 10원 단위로 나누어떨어져야 한다.

      <br>

    - **[예외]** : 수량은 공백이 아니어야 한다.
    - **[예외]** : 수량은 숫자여야 한다.
    - **[예외]** : 수량은 0개 이상이어야 한다.


- `투입 금액` 을 입력 받는다.
    - **[예외]** : 투입 금액은 최소 한번 결제가 가능한 금액이어야한다.
    - **[예외]** : 투입 금액은 숫자여야한다.

  <br>

- `구매할 상품` 을 입력 받는다.
    - **[예외]** : 구매 할 상품명이 자판기에 있어야 한다.
    - **[예외]** : 구매 할 상품의 재고가 있어야한다.
    - **[예외]** : 구매 할 상품명에 공백이 들어올 경우 제거해주자.

### 기능

- 최초에 자판기 보유 금액 들어오면, 해당 금액 만큼 `랜덤으로 동전을 생성`한다.
- `음료를 구매`한다.
- `남은 잔돈을 계산`한다.
- `음료를 더 구매할 수 있는지 확인`한다.
    - `있을 경우` 1,2,3 을 반복
    - `없을 경우` (남은 금액이 살수 있는 제품 최저가 보다 적거나, 상품 수량이 0 일 경우)
        - `최소 동전 갯수로 잔돈을 반환`한다.

### 출력

- `입력 안내문`을 `내림차순`으로 출력한다.
- `보유한 동전`을 출력한다.
- `현재 남아있는 금액`을 출력한다.
- `잔돈`을 출력한다.


---


### 수행한 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

---


## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
