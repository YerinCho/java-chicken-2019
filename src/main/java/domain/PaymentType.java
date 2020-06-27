package domain;

import java.util.Arrays;

public enum PaymentType {
    CARD(1),
    CASH(2);

    private final int payment;

    PaymentType(final int payment) {
        this.payment = payment;
    }

    public static PaymentType of(int number) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.payment == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결제방식입니다."));
    }

}
