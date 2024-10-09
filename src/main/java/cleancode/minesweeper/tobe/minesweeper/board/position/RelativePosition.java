package cleancode.minesweeper.tobe.minesweeper.board.position;

import java.util.List;

public class RelativePosition {

    public final static List<RelativePosition> SURROUNDED_POSITIONS = List.of(
            RelativePosition.of(-1, -1),
            RelativePosition.of(-1, 0),
            RelativePosition.of(-1, 1),
            RelativePosition.of(0, -1),
            RelativePosition.of(0, 1),
            RelativePosition.of(1, -1),
            RelativePosition.of(1, 0),
            RelativePosition.of(1, 1));

    private final int deltaRow;
    private final int deltaCol;

    private RelativePosition(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    public static RelativePosition of(int deltaRow, int deltaCol) {
        return new RelativePosition(deltaRow, deltaCol);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + deltaRow;
        result = prime * result + deltaCol;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RelativePosition other = (RelativePosition) obj;
        if (deltaRow != other.deltaRow)
            return false;
        if (deltaCol != other.deltaCol)
            return false;
        return true;
    }

    public int getDeltaCol() {
        return deltaCol;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

}
