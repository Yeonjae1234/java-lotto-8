package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.WinningChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
            List<Lotto> lottos = purchaseAmount.generateLottoList(lottoListGenerator, lottoGenerator);
            assertThat(lottos).hasSize(8);
        });

    }

    @Test
    public void winningChecker_findRank_SECOND(){
        assertSimpleTest(()->{
            WinningChecker winningChecker = new WinningChecker();
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(winningLotto,7);
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            winningChecker.findRank(userLotto,winningNumbers);
            assertThat(winningChecker.totalResult.get(Rank.SECOND)).isEqualTo(1);
        });
    }

    @Test
    public void winningChecker_findRank_NULL(){
        assertSimpleTest(()->{
            WinningChecker winningChecker = new WinningChecker();
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(winningLotto,7);
            Lotto userLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            winningChecker.findRank(userLotto,winningNumbers);
            assertThat(winningChecker.totalResult.get(Rank.SECOND)).isEqualTo(0);
        });
    }

    @Test
    public void winningChecker_checkTotalResult(){
        assertSimpleTest(()->{
            WinningChecker winningChecker = new WinningChecker();
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(winningLotto,7);
            ArrayList<Lotto> userLottos = new ArrayList<>();
            userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
            userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
            userLottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
            userLottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
            userLottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
            userLottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
            userLottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
            winningChecker.checkTotalResult(userLottos,winningNumbers);
        });
    }

}
