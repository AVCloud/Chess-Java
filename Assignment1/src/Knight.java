public class Knight extends GamePiece {

    public Knight(String owner, ChessLocation initialLocation, ChessGame game) {
        this.owner = owner;
        chessLocation = initialLocation;
        chessGame = game;
    }

    public void moveTo(ChessLocation newLocation) {
        chessLocation.setRowAndCol(newLocation.getRow(), newLocation.getCol());
    }

    protected boolean validMove(ChessLocation location) {
        boolean valid = false;
        if (!locationInBounds(location)) {
            return false;
        }
        if (Math.abs(chessLocation.getRow() - location.getRow()) == 2 && Math.abs(chessLocation.getCol() - location.getCol()) == 1) {
            valid = true;
        }
        if (Math.abs(chessLocation.getRow() - location.getRow()) == 1 && Math.abs(chessLocation.getCol() - location.getCol()) == 2) {
            valid = true;
        }
        return valid;
    }
}
