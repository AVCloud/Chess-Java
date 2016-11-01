package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Pawn extends ChessPiece{

    public Pawn(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'P';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'p';
        }
    }

    public boolean validMove(ChessLocation location) {
        return true;
    }
}
