public abstract class GamePiece {

    protected ChessGame chessGame;
    protected String owner;
    protected ChessLocation chessLocation;

    public abstract void moveTo(ChessLocation newLocation);

    protected abstract boolean validMove(ChessLocation location);

    protected boolean locationInBounds(ChessLocation location) {
        return location.getRow() >= 0 && location.getRow() < 8 && location.getRow() >= 0 && location.getCol() < 8;
    }

    protected ChessLocation getChessLocation() {
        return chessLocation;
    }
}
