package Chess;

import GameEntities.*;

/**
 * The ChessGame class is used for holding chess objects
 * which contains the board, pieces and handles alternating turns.
 */
public class ChessGame {

    private ChessBoard chessBoard;

    /**
     * Create new instances of nessary properties.
     */
    public ChessGame() {
        // Top side
        int side = 0;
        int one = (side > 0) ? -1: 1;
        String player = "player1";
        int colIncerment = 0;
        chessBoard = new ChessBoard();
        // Rook
        ChessPiece r1 = new Rook(player, new ChessLocation(side, colIncerment), this);
        ChessPiece r2 = new Rook(player, new ChessLocation(side, 7-colIncerment), this);
        colIncerment += 1;

        // Knight
        ChessPiece n1 = new Knight(player, new ChessLocation(side, colIncerment), this);
        ChessPiece n2 = new Knight(player, new ChessLocation(side, 7-colIncerment), this);
        colIncerment += 1;

        // Bishop
        ChessPiece b1 = new Bishop(player, new ChessLocation(side, colIncerment), this);
        ChessPiece b2 = new Bishop(player, new ChessLocation(side, 7-colIncerment), this);
        colIncerment += 1;

        // King & Queen
        ChessPiece k = new King(player, new ChessLocation(side, colIncerment), this);
        ChessPiece q = new Queen(player, new ChessLocation(side, 7-colIncerment), this);

        // Pawns
        for (int i = 0; i < 8; i++) {
            ChessPiece p = new Pawn(player, new ChessLocation(side + one, i), this);
        }
    }

    /**
     * Returns the ChessBoard.
     * @return The board object of the chess game.
     */
    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
