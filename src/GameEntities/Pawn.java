package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Pawn extends ChessPiece {

    private boolean firstMove;
    private int one;

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
        boolean valid = false;

        if (location.getCol() == chessLocation.getCol()) {
            if (location.getRow() - chessLocation.getRow() == one) {
                valid = true; 
            } else if (firstMove && (location.getRow() - chessLocation.getRow() == (one * 2))) {
                valid = true;
            }
        } else if (Math.abs(location.getCol() - chessLocation.getCol()) == 1) {
            if (game.getChessBoard().isPieceAt(location.getRow(), location.getCol()) && location.getRow() - chessLocation.getRow() == one) {
                valid = true;
            }
        }

        if (firstMove) {
            firstMove = false;
        }

        return valid;
    }
}
