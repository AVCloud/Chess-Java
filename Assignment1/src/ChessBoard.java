public class ChessBoard {
    private Knight[][] board;

    public ChessBoard() {
        board = new Knight[8][8];
    }

    public boolean isPieceAt(int row, int col) {
        if (board[row][col] != null) {
            return true;
        }
        return false;
    }

    public void placePieceAt(Knight knight, ChessLocation location) {
        if (isPieceAt(location.getRow(), location.getCol())) {
            System.out.println("Piece is here");
            //Knight currentKnight = board[location.getRow()][location.getCol()];
        }
        board[location.getRow()][location.getCol()] = knight;
        knight.moveTo(location);
    }

    public void displayBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}
