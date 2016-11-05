package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Rook extends ChessPiece {
    
    public Rook(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'R';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'r';
        }
    }

    @Override
    public boolean validMove(ChessLocation location) {
        if ((chessLocation.getRow() == location.getRow()) != (chessLocation.getCol() == location.getCol())) {
            return checkLineOfSight(chessLocation, location);
        }
        return false;
    }
}
