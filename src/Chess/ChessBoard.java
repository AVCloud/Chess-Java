package Chess;

import GameEntities.GamePiece;

public class ChessBoard {
    private GamePiece[][] board;

    public ChessBoard() {
        board = new GamePiece[8][8];
    }

    public boolean isPieceAt(int row, int col) {
        return board[row][col] != null;
    }

    public void placePieceAt(GamePiece piece, ChessLocation location) {
        if (locationInBounds(location) && piece.validMove(location)) {
            if (isPieceAt(location.getRow(), location.getCol())) {
                System.out.println("Piece is here");
                removePieceAt(location);
            }
            removePieceAt(piece.getChessLocation());
            board[location.getRow()][location.getCol()] = piece;
            piece.moveTo(location);
        } else {
            System.out.println("Not a valid move, try again.");
        }
    }

    private void removePieceAt(ChessLocation location) {
        board[location.getRow()][location.getCol()] = null;
    }

    public void setupPieceAt(GamePiece piece, ChessLocation location) {
        board[location.getRow()][location.getCol()] = piece;
        piece.moveTo(location);
    }

    private boolean locationInBounds(ChessLocation location) {
        return location.getRow() >= 0 && location.getRow() < 8 && location.getRow() >= 0 && location.getCol() < 8;
    }

    public void displayBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int row = 0; row < 8; row++) {
            System.out.print(row);
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    System.out.print(" P");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
