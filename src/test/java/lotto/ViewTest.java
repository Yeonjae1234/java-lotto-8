package lotto;

import lotto.domain.LottoListDTO;
import lotto.domain.LottoSnapshot;
import lotto.domain.Person;
import lotto.domain.Rank;
import lotto.validator.Validator;
import lotto.view.View;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;


import java.util.EnumMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest extends NsTest {

    View view = new View(new Validator());

    @Test
    public void printLottoList() {
        assertSimpleTest(() -> {
            LottoSnapshot lotto1 = new LottoSnapshot(List.of(1, 2, 3, 4, 5, 6));
            LottoSnapshot lotto2 = new LottoSnapshot(List.of(7, 8, 9, 10, 11, 12));
            LottoListDTO lottoListDTO = new LottoListDTO(List.of(lotto1, lotto2));
            view.printLottoList(lottoListDTO);
            assertThat(output()).contains(
                    "2개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[7, 8, 9, 10, 11, 12]"
            );
        });

    }

    @Test
    public void printRankCount(){
        assertSimpleTest(()->{
            EnumMap<Rank, Integer> rankIntegerEnumMap = new EnumMap<>(Rank.class);
            rankIntegerEnumMap.put(Rank.FIRST, 0);
            rankIntegerEnumMap.put(Rank.SECOND, 0);
            rankIntegerEnumMap.put(Rank.THIRD, 0);
            rankIntegerEnumMap.put(Rank.FOURTH, 0);
            rankIntegerEnumMap.put(Rank.FIFTH, 1);
            view.printRankCount(rankIntegerEnumMap);
            assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
            );
        });
    }

    @Test
    public void printReturnRate(){
        assertSimpleTest(()->{
            view.printReturnRate(0.6246);
            assertThat(output()).contains(
                    "총 수익률은 62.5%입니다."
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
