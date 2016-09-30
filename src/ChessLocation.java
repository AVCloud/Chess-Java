public class ChessLocation {
    private int row;
    private int col;

    public ChessLocation(int row, int col) {
        setRowAndCol(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRowAndCol(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
