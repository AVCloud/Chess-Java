public class ChessLocation {
    private Integer row;
    private Integer col;

    public ChessLocation(int row, int col) {
        setRowAndCol(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setNull() {
        row = null;
        col = null;
    }

    public void setRowAndCol(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
