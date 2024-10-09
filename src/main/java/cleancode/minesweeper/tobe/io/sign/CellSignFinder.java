package cleancode.minesweeper.tobe.io.sign;

import java.util.List;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

public class CellSignFinder {
    private static final List<CellSignProvidable> cellSignProviders = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider(),
            new UncheckedCellSignProvider());

    public String findCellSignFrom(CellSnapshot snapshot) {
        return cellSignProviders.stream()
                .filter(provider -> provider.supports(snapshot))
                .findFirst()
                .map(provider -> provider.provide((snapshot)))
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 코드입니다."));

    }
}
