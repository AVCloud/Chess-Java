package GameEntities;

import Chess.ChessLocation;
import Chess.ChessGame;
import java.util.ArrayList;

public class King extends ChessPiece {
    
    private ArrayList<ChessPiece> threateningPieces;
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
        threateningPieces = new ArrayList<>();
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

    }

    private ChessPiece locationInDanger(ChessLocation location) {


    }

    private void updateVertical(ChessLocation location, int one) {
        ChessBoard board = chessGame.getChessBoard();
        int inc = one;
        while (location.getRow() + inc < 8 &&
                location.getRow() + inc > 0) {

            ChessPiece piece = board.getPieceAt(new ChessLocation(location.getRow() + inc, location.getCol()));
            if (piece != null) {
                if (piece.getOwner().equalsIgnoreCase(owner)) {
                    return;
                } else if (Character.toLowerCase(piece.getId()) == 'q' ||
                            Character.toLowerCase(piece.getId()) == 'r' ||
                            Character.toLowerCase(piece.getId()) == 'k' ||
                            Character.toLowerCase(piece.getId()) == 'p') {

                    threateningPieces.add(piece);
                }
            } else {
                inc += one;
            }
        }
    }

    private void updateHorizontal(ChessLocation location, int one) {
        ChessBoard board = chessGame.getChessBoard();
        int inc = one;
        while (location.getCol() + inc < 8 &&
                location.getCol + inc > 0) {

            ChessPiece piece = board.getPieceAt(new ChessLocation(location.getRow(), location.getCol() + inc));
            if (piece != null) {
                if (piece.getOwner().equalsIgnoreCase(owner)) {
                    return;
                } else if (Character.toLowerCase(piece.getId()) == 'q' ||
                            Character.toLowerCase(piece.getId()) == 'r' ||
                            Character.toLowerCase(piece.getId()) == 'k' ||
                            Character.toLowerCase(piece.getId()) == 'p') {

                    threateningPieces.add(piece);
                }
            } else {
                inc += one;
            }
        }

    }
}
