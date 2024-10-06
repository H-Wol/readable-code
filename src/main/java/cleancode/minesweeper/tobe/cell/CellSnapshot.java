package cleancode.minesweeper.tobe.cell;

public class CellSnapshot {
    private final CellSnapshotStatus status;
    private final int nearbyLandMineCount;

    private CellSnapshot(CellSnapshotStatus status, int nearbyLandMineCount) {
        this.status = status;
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    public static CellSnapshot of(CellSnapshotStatus status, int nearbyLandMineCount) {
        return new CellSnapshot(status, nearbyLandMineCount);
    }

    public static CellSnapshot ofEmpty() {
        return of(CellSnapshotStatus.EMPTY, 0);
    }

    public static CellSnapshot ofFlag() {
        return of(CellSnapshotStatus.FLAG, 0);
    }

    public static CellSnapshot ofNumber(int nearbyLandMineCount) {
        return of(CellSnapshotStatus.NUMBER, nearbyLandMineCount);
    }

    public static CellSnapshot ofLandmine() {
        return of(CellSnapshotStatus.LAND_MINE, 0);
    }

    public static CellSnapshot ofUnchecked() {
        return of(CellSnapshotStatus.UNCHECKED, 0);
    }

    public CellSnapshotStatus getStatus() {
        return status;
    }

    public int getNearbyLandMineCount() {
        return nearbyLandMineCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + nearbyLandMineCount;
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
        CellSnapshot other = (CellSnapshot) obj;
        if (status != other.status)
            return false;
        if (nearbyLandMineCount != other.nearbyLandMineCount)
            return false;
        return true;
    }

}
