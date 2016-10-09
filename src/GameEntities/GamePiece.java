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

    public abstract void moveTo(ChessLocation newLocation);
    public abstract boolean validMove(ChessLocation location);

    /**
     * Returns the location of piece.
     * @return ChessLocation of the GamePiece.
     */
    public ChessLocation getChessLocation() {
        return chessLocation;
    }
}
