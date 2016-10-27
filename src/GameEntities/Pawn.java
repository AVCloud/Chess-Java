package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Pawn extends ChessPiece{

    public Pawn(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
    }

    public boolean validMove(ChessLocation location) {
        return true;
    }
}
