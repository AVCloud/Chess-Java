package GameEntities;

import Chess.ChessGame;
import Chess.ChessLocation;

public abstract class GamePiece {

    protected ChessGame chessGame;
    protected String owner;
    protected ChessLocation chessLocation;

    public abstract void moveTo(ChessLocation newLocation);
    public abstract boolean validMove(ChessLocation location);

    public ChessLocation getChessLocation() {
        return chessLocation;
    }
}
