package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DomainTest {

    @DisplayName("PurchaseAmount의 금액이 1000원 단위가 아니면 Exception을 발생시킨다.")
    @Test
    public void purchaseAmount_unit_false(){
        assertThatThrownBy(() -> new PurchaseAmount(123)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Rank.valueOf로 SECOND 찾기")
    @Test
    public void rank_valueOf_SECOND(){
        assertSimpleTest(()->{
            assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        });

    }

    @DisplayName("Rank.valueOf로 THIRD 찾기")
    @Test
    public void rank_valueOf_THIRD(){
        assertSimpleTest(()->{
            assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        });

    }

}
