package GameEntities;

import Chess.ChessGame;
import Chess.ChessLocation;

/**
 * GamePiece is a general piece class for chess.
 */
public abstract class GamePiece {

    protected ChessGame chessGame;
    protected String owner;
    protected ChessLocation chessLocation;

   public abstract boolean validMove(ChessLocation location);

    /**
     * Sets the private members of the GamePiece. Such as it's owner
     * the lcoation and the game it belongs to.
     * @param owner Owner string.
     * @param initialLocation Location to set knight in.
     * @param game Game that the knight belongs too.
     */
    public GamePiece(String owner, ChessLocation initialLocation, ChessGame game) {
        this.owner = owner;
        chessLocation = initialLocation;
        chessGame = game;
        chessGame.getChessBoard().setupPieceAt(this, chessLocation);
    }

    /**
     * Sets the location of the GamePiece.
     * @param newLocation The new location of the knight.
     */
    public void moveTo(ChessLocation newLocation) {
        chessLocation = newLocation;
    }

    /**
     * Returns the location of piece.
     * @return ChessLocation of the GamePiece.
     */
    public ChessLocation getChessLocation() {
        return chessLocation;
    }
}
