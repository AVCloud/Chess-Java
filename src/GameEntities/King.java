package GameEntities;

import Chess.ChessLocation;
import Chess.ChessBoard;
import Chess.ChessGame;
import java.util.ArrayList;

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

    @Override
    public void updateThreateningLocation(ChessLocation newLocation) {
        for (int row = -1; row >= 1; row++) {
            for (int col = -1; col >= 1; col++) {
                ChessLocation location = new ChessLocation(chessLocation.getRow() + row, chessLocation.getCol() + col);
                if (ChessBoard.locationInBounds(location)) {
                    ChessPiece piece = chessGame.getChessBoard().getPieceAt(location);
                    if (piece != null &&
                        !piece.getOwner().equalsIgnoreCase(owner)) {

                        threateningLocations.add(location);
                    }
                }
            }
        }
    }

    private ChessPiece locationInDanger(ChessLocation destination) {
        ChessBoard board = chessGame.getChessBoard();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = board.getPieceAt(new ChessLocation(row, col));
                if (piece != null &&
                    !piece.getOwner().equals(owner)) {

                    piece.updateThreateningLocation();
                    for (ChessLocation l: piece.getThreateningLocations()) {
                        if (destination.equals(l)) {
                            return piece;
                        }
                    }
                }
            }
        }
        return null;
    }

    public ChessPiece check() {
        ChessPiece piece = locationInDanger(chessLocation);
        return piece;
    }
}
