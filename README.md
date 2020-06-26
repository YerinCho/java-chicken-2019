# java-chicken-2019

## 요구사항

+ [ ] 메인 화면에서 주문등록, 결제하기, 프로그램 종료 선택 가능
    + [ ] 1,2,3 외의 입력이 들어온 경우 예외처리
+ [ ] 주문 등록
    + [ ] 테이블 목록 표시
        + [ ] 1개 이상 주문이 된 테이블은 ₩ 표
    + [ ] 테이블 선택
        + [ ] 1,2,3,5,6,8 외의 입력 들어온 경우 예외처리
    + [ ] 메뉴 표시
    + [ ] 메뉴 선택
        + [ ] 1,2,3,4,5,6,21,22 외 입력 들어온 경우 예외처리
    + [ ] 메뉴 수량 입력
        + [ ] 0 이하 숫자, 문자 입력시 예외처리
        + [ ] 한 메뉴의 이미 주문한 수량 + 입력한 수량이 100 이상이면 예외처리
+ [ ] 결제하기
    + [ ] 테이블 목록 표시 - 주문 등록과 같음
    + [ ] 테이블 선택 - 주문 등록과 같음
    + [ ] 주문 내역 표시 - 메뉴, 수량, 금액
    + [ ] 신용카드와 현금 선택
        + [ ] 1, 2 외 입력시 예외처리
    + [ ] 결제 금액 표시
        + [ ] 치킨종류의 주문수량이 10마리마다 10000원 할인 
        + [ ] 현금결제(2)시 5% 할인 - 치킨할인 후 중복할인 적용
+ [ ] 프로그램 종료
    + [ ] 프로그램 종료 전까지는 계속 유지
+ [ ] 주문, 계산 실패 시 이유를 보여주고 다시 가능하도록 구현