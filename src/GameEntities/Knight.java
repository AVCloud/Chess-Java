package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;

public class Knight extends GamePiece {

    public Knight(String owner, ChessLocation initialLocation, ChessGame game) {
        this.owner = owner;
        chessLocation = initialLocation;
        chessGame = game;
        chessGame.getChessBoard().setupPieceAt(this, chessLocation);
    }

    public void moveTo(ChessLocation newLocation) {
        chessLocation.setRow(newLocation.getRow());
        chessLocation.setCol(newLocation.getCol());
    }

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
