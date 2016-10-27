package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Knight extends GamePiece {

    /**
     * Sets the private members of the Knight. Such as it's owner
     * the lcoation and the game it belongs to.
     * @param owner Owner string.
     * @param initialLocation Location to set knight in.
     * @param game Game that the knight belongs too.
     */
    public Knight(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);
    }

    /**
     * Checks if the move is valid for knight piece.
     * @param location Checks if the location is a valid move.
     * @return Boolean if the location is valid or not.
     */
    public boolean validMove(ChessLocation location) {
        boolean valid = false;
        if (Math.abs(chessLocation.getRow() - location.getRow()) == 2 && Math.abs(chessLocation.getCol() - location.getCol()) == 1) {
            valid = true;
        }
        if (Math.abs(chessLocation.getRow() - location.getRow()) == 1 && Math.abs(chessLocation.getCol() - location.getCol()) == 2) {
            valid = true;
        }
        return valid;
    }
}
