package lotto;

import lotto.domain.*;
import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.ReturnRateCalculator;
import lotto.service.WinningChecker;
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

    @DisplayName("WinningNumber와 Lotto로 결과 확인하기")
    @Test
    public void winningNumbers_SECOND(){
        assertSimpleTest(()->{
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(winningLotto,7);
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Rank result = winningNumbers.countMatchNumbers(userLotto);
            assertThat(result).isEqualTo(Rank.SECOND);
        });
    }

    @Test
    public void person_calculateReturnRate(){
        assertSimpleTest(()->{
            PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
            Person person = new Person(purchaseAmount, new LottoListGenerator(), new LottoGenerator());
            WinningChecker winningChecker = new WinningChecker();
            winningChecker.totalResult.put(Rank.FIFTH, 1);
            double v = person.calculateReturnRate(winningChecker.totalResult, new ReturnRateCalculator());
            assertThat(v).isEqualTo(0.625);
        });
    }

}
