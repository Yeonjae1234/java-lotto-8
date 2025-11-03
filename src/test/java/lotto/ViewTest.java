package lotto;

import lotto.domain.LottoListDTO;
import lotto.domain.LottoSnapshot;
import lotto.domain.Person;
import lotto.validator.Validator;
import lotto.view.View;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
