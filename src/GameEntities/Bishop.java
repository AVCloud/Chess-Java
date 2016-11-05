package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Bishop extends ChessPiece {
    
    public Bishop(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'B';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'b';
        }
    }

    @Override
    public boolean validMove(ChessLocation location) {
        if (Math.abs(chessLocation.getRow() - location.getRow()) == Math.abs(chessLocation.getCol() - location.getCol())) {
            return checkLineOfSight(chessLocation, location);
        }
        return false;
    }
}
