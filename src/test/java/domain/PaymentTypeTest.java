package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTypeTest {

    @Test
    @DisplayName("입력에 따른 결제방식 반환")
    void of() {
        assertThat(PaymentType.of(1)).isEqualTo(PaymentType.CARD);
        assertThat(PaymentType.of(2)).isEqualTo(PaymentType.CASH);
    }

    @Test
    @DisplayName("유효하지 않은 결제방식 예외처리")
    void validateOf() {
        assertThatThrownBy(() -> PaymentType.of(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 결제방식입니다.");
    }

}