# 미션 - 자판기

### 🎯 구현할 기능 목록

- [x] 관리자는 자판기가 보유하고 있는 금액을 입력한다.
    - [x] [ERROR] 입력한 금액이 `숫자가 아닌 경우`
    - [x] [ERROR] 입력한 금액이 `0인 경우`
    - [x] [ERROR] 입력한 금액이 `10원으로 나누어떨어지지 않는 경우`
- [x] 자판기는 보유하고 있는 금액을 동전으로 무작위로 생성한다.
- [ ] 자판기는 잔돈을 돌려줄 때, 최소 개수의 동전으로 잔돈을 돌려준다.
- [x] 관리자는 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다. (상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.)
    - [x] [ERROR] 추가하는 상품에 `입력 형식이 잘못된 경우`
    - [x] [ERROR] 추가하는 상품에 `중복된 상품이 있는 경우`
    - [x] [ERROR] 추가하는 상품의 가격이 `100원보다 작거나`, `10원으로 나누어떨어지지 않는 경우`
- [ ] 사용자는 자판기에 금액을 투입할 수 있다.
    - [ ] [ERROR] 입력한 금액이 `숫자가 아닌 경우`
    - [ ] [ERROR] 입력한 금액이 `0인 경우`
    - [ ] [ERROR] 입력한 금액이 `10원으로 나누어떨어지지 않는 경우`
- [ ] 사용자는 자판기에 있는 상품을 구매할 수 있다.
    - [ ] [ERROR] 입력한 상품이 `없는 경우`
- [ ] 자판기는 사용자의 금액이 상품의 최저 금액보다 적거나, 모든 상품이 소진된 경우 잔돈을 돌려준다.
- [ ] [종료] 자판기는 잔돈을 반환할 수 없는 경우, 반환할 수 있는 금액만 반환한다.
    - [ ] 반환되니 않은 금액은 자판기에 남는다.

### ✅ 확인할 목록

- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] indent depth를 3이 넘지 않도록 구현한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] else, switch 예약어를 쓰지 않는다.
- [ ] Coin 클래스를 활용해 구현한다.
    - [ ] amount의 접근 제어자 private을 변경할 수 없다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API 를 활용해 구현해야 한다.
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.