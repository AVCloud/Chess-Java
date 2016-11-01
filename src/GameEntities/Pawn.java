package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Pawn extends ChessPiece {

    boolean firstMove;
    int one;

    public Pawn(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'P';
            one = 1;
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'p';
            one = -1;
        }
        firstMove = true;
    }

    public boolean validMove(ChessLocation location) {
        if (location.getCol() == chessLocation.getCol()) {
            if (location.getRow() - chessLocation.getRow() == one) {
                return true;
            }
            if ((location.getRow() - chessLocation.getRow() == (one * 2)) && firstMove) {
                firstMove = false;
                return true;
            }
        }
        return false;
    }
}
