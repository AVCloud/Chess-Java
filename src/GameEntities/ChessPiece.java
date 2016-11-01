package GameEntities;

import Chess.ChessGame;
import Chess.ChessLocation;

/**
 * ChessPiece is a general piece class for chess.
 */
public abstract class ChessPiece {

    protected ChessGame chessGame;
    protected String owner;
    protected ChessLocation chessLocation;
    protected char id;

   public abstract boolean validMove(ChessLocation location);

    /**
     * Sets the private members of the ChessPiece. Such as it's owner
     * the lcoation and the game it belongs to.
     * @param owner Owner string.
     * @param initialLocation Location to set knight in.
     * @param game Game that the knight belongs too.
     */
    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game) {
        this.owner = owner;
        chessLocation = initialLocation;
        chessGame = game;
        chessGame.getChessBoard().setupPieceAt(this, chessLocation);
    }

    /**
     * Sets the location of the ChessPiece.
     * @param newLocation The new location of the knight.
     */
    public void moveTo(ChessLocation newLocation) {
        chessLocation = newLocation;
    }

    /**
     * Returns the location of piece.
     * @return ChessLocation of the ChessPiece.
     */
    public ChessLocation getChessLocation() {
        return chessLocation;
    }

    public char getId() {
        return id;
    }
}
