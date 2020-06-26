package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    @Test
    @DisplayName("해당 번호의 테이블인지 확인")
    void isTableNumber() {
        Table table = new Table(3);
        assertThat(table.isTableNumber(3)).isTrue();
        assertThat(table.isTableNumber(4)).isFalse();
    }

}