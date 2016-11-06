package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class King extends ChessPiece {
    
    public King(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'K';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'k';
        }
    }

    @Override
    public boolean validMove(ChessLocation location) {
        if (Math.abs(chessLocation.getRow() - location.getRow()) <= 1 && Math.abs(chessLocation.getCol() - location.getCol()) <= 1) {
            return checkLineOfSight(chessLocation, location);
        }
        return false;
    }
}
