package lotto;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {
    LottoListGenerator lottoListGenerator = new LottoListGenerator();
    LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("구입 금액만큼 가능한 로또 리스트를 생성한다.")
    @Test
    public void lottoListGenerator(){
        assertSimpleTest(() -> {
            assertThat(lottoListGenerator.generateLottoList(8000, 1000, new LottoGenerator()))
                    .hasSize(8)            ;
        });
    }

    @DisplayName("PurchaseAmount의 금액만큼 가능한 로또 리스트를 생성한다.")
    @Test
    public void purchaseAmount_generateLottoList(){
        assertSimpleTest(()->{
            PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
            assertThat(purchaseAmount.generateLottoList(lottoListGenerator, lottoGenerator))
                    .hasSize(8);
        });

    }
}
