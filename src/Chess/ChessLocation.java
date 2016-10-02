package Chess;

public class ChessLocation {
    private int row;
    private int col;

    public ChessLocation(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
