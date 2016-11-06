package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Pawn extends ChessPiece {

    private boolean firstMove;
    private int one;

    /** 
     * Constructs a new Pawn piece.
     * @param owner Owner string.
     * @param initialLocation Location to set Pawn in.
     * @param game Game that the Pawn belongs too.
     */
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

    /** Checks if more is valid for Pawns.
     * @return Valid move or not.
     */
    @Override
    public boolean validMove(ChessLocation location) {
        boolean valid = false;

        if (location.getCol() == chessLocation.getCol()) {
            if (location.getRow() - chessLocation.getRow() == one) {
                valid = true; 
            } else if (firstMove && (location.getRow() - chessLocation.getRow() == (one * 2))) {
                valid = true;
            }
        } else if (Math.abs(location.getCol() - chessLocation.getCol()) == 1) {
            if (chessGame.getChessBoard().isPieceAt(location.getRow(), location.getCol()) && location.getRow() - chessLocation.getRow() == one) {
                valid = true;
            }
        }

        if (firstMove) {
            firstMove = false;
        }

        return valid;
    }
}
