package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String UNCHECKED_SIGN = "□";
    String FLAG_SIGN = "⚑";

    boolean isLandMine();

    boolean hasLandMineCount();

    String getSign();

    public void flag();

    public void open();

    public boolean isOpened();

    public boolean isChecked();

}
