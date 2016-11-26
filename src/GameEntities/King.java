package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class King extends ChessPiece {
    
    /**
     * Creates a King piece.
     * @param owner Owner string.
     * @param initialLocation Location to set King in.
     * @param game Game that the King belongs too.
     */
    public King(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
        if (owner.equalsIgnoreCase("player1")) {
            id = 'K';
        } else if (owner.equalsIgnoreCase("player2")) {
            id = 'k';
        }
    }

    /** Checks if more is valid for King, then moves the piece.
     * @return Valid move or not.
     */
    @Override
    public boolean moveTo(ChessLocation location) {
        if (Math.abs(chessLocation.getRow() - location.getRow()) <= 1 && 
            Math.abs(chessLocation.getCol() - location.getCol()) <= 1) {

            return checkLineOfSight(chessLocation, location) && super.moveTo(location);
        }
        return false;
    }
}
