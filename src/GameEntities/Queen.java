package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Queen extends ChessPiece {
    
    public Queen(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'Q';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'q';
        }
    }

    @Override
    public boolean validMove(ChessLocation location) {
        return checkLineOfSight(chessLocation, location);
    }
}
