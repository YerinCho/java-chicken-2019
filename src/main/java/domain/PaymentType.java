package domain;

import java.util.Arrays;
import java.util.List;

public enum PaymentType {
    CARD(1) {
        @Override
        public double calculate(List<Order> orders) {
            return orders.stream()
                    .mapToInt(Order::getTotalPrice)
                    .sum();
        }
    },

    CASH(2) {
        @Override
        public double calculate(List<Order> orders) {
            double total = orders.stream()
                    .mapToInt(Order::getTotalPrice)
                    .sum();
            return total * CASH_DISCOUNT_RATE;
        }
    };

    public static final double CASH_DISCOUNT_RATE = 0.95;

    private final int payment;

    PaymentType(final int payment) {
        this.payment = payment;
    }

    public abstract double calculate(List<Order> orders);

    public static PaymentType of(int number) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.payment == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결제방식입니다."));
    }

}
