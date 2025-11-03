package lotto.domain;

import java.util.List;

public record LottoListDTO(
        List<LottoSnapshot> lottoList
) {}
