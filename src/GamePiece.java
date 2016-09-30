public abstract class GamePiece {

    protected ChessGame chessGame;
    protected String owner;
    protected ChessLocation chessLocation;

    public abstract void moveTo(ChessLocation newLocation);

    protected abstract boolean validMove(ChessLocation location);

    protected boolean locationInBounds(ChessLocation location) {
        if(location.getRow() >= 0 && location.getRow() < 8 && location.getRow() >= 0 && location.getCol() < 8) {
            return true;
        }
        return false;
    }

    protected ChessLocation getChessLocation() {
        return chessLocation;
    }
}
