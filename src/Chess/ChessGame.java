package Chess;

import GameEntities.*;

/**
 * The ChessGame class is used for holding chess objects
 * which contains the board, pieces and handles alternating turns.
 */
public class ChessGame {

    private ChessBoard chessBoard;
    //TEMP FOR ASSINGMENT ONE
    private ChessPiece firstPiece;
    private ChessPiece pawn;

    /**
     * Create new instances of nessary properties.
     */
    public ChessGame() {
        chessBoard = new ChessBoard();
        firstPiece = new Knight("player1", new ChessLocation(0,0), this);
        pawn = new Pawn("player1", new ChessLocation(0,1), this);
    }

    /**
     * Returns the ChessBoard.
     * @return The board object of the chess game.
     */
    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
