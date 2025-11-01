package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DomainTest {

    @DisplayName("PurchaseAmount의 금액이 1000원 단위가 아니면 Exception을 발생시킨다.")
    @Test
    public void purchaseAmount_unit_false(){
        assertThatThrownBy(() -> new PurchaseAmount(123)).
                isInstanceOf(IllegalArgumentException.class);
    }

}
